package com.example.startupappgro.plant.camera


import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.startupappgro.databinding.ActivityCameraAnimalBinding
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.*
import com.example.startupappgro.R
import com.example.startupappgro.adapter.AdapterPreviewDiagnostic
import com.example.startupappgro.model.ModelPreviewDiagnostic
import com.example.startupappgro.provider.ProviderPreviewDiagnostic
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class CameraAnimalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraAnimalBinding
    private var imageCapture: ImageCapture? = null
    private lateinit var cameraExecutor: ExecutorService
    private var pauseAnalysis = false
    private lateinit var bitmapBuffer: Bitmap
    private var imageRotationDegrees: Int = 0
    companion object{
        private const val FILENAME_FORMAT = "dd/MM/yyy/"
        private val TAG = CameraAnimalActivity::class.java.simpleName

        private const val ACCURACY_THRESHOLD = 0.5f
        private const val MODEL_PATH = "coco_ssd_mobilenet_v1_1.0_quant.tflite"
        private const val LABELS_PATH = "coco_ssd_mobilenet_v1_1.0_labels.txt"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startCamera()
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.cameraCaptureButton.setOnClickListener {
            takePhoto()
            binding.cameraCaptureButton.setShowProgress(true, null)
            it.isEnabled = false
            if (!pauseAnalysis){
                pauseAnalysis = true
                val matrix = Matrix().apply {
                    postRotate(imageRotationDegrees.toFloat())
                }
                val uprightImage = Bitmap.createBitmap(
                    bitmapBuffer, 0, 0, bitmapBuffer.width, bitmapBuffer.height, matrix, true
                )
                binding.imagePredicted.setImageBitmap(uprightImage)
                binding.imagePredicted.visibility = View.VISIBLE
            }
            it.isEnabled = true
        }
        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun initAdapter() {
        val recycler = binding.rvPreviewDiagnostic
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = AdapterPreviewDiagnostic(ProviderPreviewDiagnostic.previewDiagnosticList){
            onItemSelected(it)
        }
    }

    private fun onItemSelected(it: ModelPreviewDiagnostic) {
        Snackbar.make(binding.btnBack, "Funcionalidad en desarrollo", Snackbar.LENGTH_SHORT).show()
    }

    fun MaterialButton.setShowProgress(
        showProgress: Boolean?,
        textSource: String?
    ){
        iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
        isClickable = showProgress == false
        text = if (showProgress == true) "" else textSource
        icon = if (showProgress == true){
            CircularProgressDrawable(context).apply {
                setStyle(CircularProgressDrawable.LARGE)
                setColorSchemeColors(ContextCompat.getColor(
                    context, R.color.white))
                start()
            }
        } else {
            getDrawable(R.drawable.ic_round_check_circle_24).apply {
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        }
        icon?.let {
            icon.callback = object : Drawable.Callback{
                override fun invalidateDrawable(who: Drawable) {
                    this@setShowProgress.invalidate()
                }

                override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
                    TODO("Not yet implemented")
                }

                override fun unscheduleDrawable(who: Drawable, what: Runnable) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            // Preview
            val preview = Preview.Builder()
                .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                .setTargetRotation(binding.viewFinder.display.rotation)
                .build()
                .also {
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }
            imageCapture = ImageCapture.Builder().build()
            val imageAnalyzer = ImageAnalysis.Builder()
                .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                .setTargetRotation(binding.viewFinder.display.rotation)
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
                .build()
                .also {
                    it.setAnalyzer(cameraExecutor, LuminosityAnalyzer { luma ->
                        Log.d(TAG, "Average luminosity: $luma")
                    })
                }
            imageAnalyzer.setAnalyzer(cameraExecutor, ImageAnalysis.Analyzer { image ->
                if(!::bitmapBuffer.isInitialized){
                    imageRotationDegrees = image.imageInfo.rotationDegrees
                    bitmapBuffer = Bitmap.createBitmap(
                        image.width, image.height, Bitmap.Config.ARGB_8888
                    )
                    if(pauseAnalysis){
                        image.close()
                        return@Analyzer
                    }
                    image.use { bitmapBuffer.copyPixelsFromBuffer(image.planes[0].buffer) }
                }
            })
            // Select back camera as a default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture, imageAnalyzer)
            } catch(exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }
        }, ContextCompat.getMainExecutor(this))
    }
    private fun takePhoto() {
        // Get a stable reference of the modifiable image capture use case
        val imageCapture = imageCapture ?: return

        // Create time stamped name and MediaStore entry.
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
            }
        }

        // Create output options object which contains file + metadata
        val outputOptions = ImageCapture.OutputFileOptions
            .Builder(contentResolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues)
            .build()

        // Set up image capture listener, which is triggered after photo has
        // been taken
        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
                }

                override fun
                        onImageSaved(output: ImageCapture.OutputFileResults){
                    val msg = "Photo capture succeeded: ${output.savedUri}"
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                    binding.cameraCaptureButton.setShowProgress(false, null)
                    initAdapter()
                    binding.viewPartial.bringToFront()
                }
            }
        )
    }
    private fun reportPrediction(
        prediction: ObjectDetectionHelper.ObjectPrediction?
    ) = binding.viewFinder.post {
        if (prediction == null || prediction.score < ACCURACY_THRESHOLD) {
            return@post
        }
        Toast.makeText(this, prediction.label, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        cameraExecutor.apply {
            shutdown()
            awaitTermination(1000, TimeUnit.MILLISECONDS)
        }
        super.onDestroy()
    }

}