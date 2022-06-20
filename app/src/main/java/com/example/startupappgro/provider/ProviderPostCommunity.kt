package com.example.startupappgro.provider

import com.example.startupappgro.R
import com.example.startupappgro.model.ModelPostCommunity

class ProviderPostCommunity {
    companion object {
        var postCommunityList = mutableListOf<ModelPostCommunity>(
            ModelPostCommunity(
                photo = R.drawable.img,
                name = "Jackson Montenegro",
                timePost = "Hace 1 hora",
                options = R.drawable.opciones,
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                photoPost = R.drawable.relog,
                reactions = "12.4 k",
                comments = "250"
            ),
            ModelPostCommunity(
                photo = R.drawable.img,
                name = "Francisco García",
                timePost = "Hace 1 hora",
                options = R.drawable.opciones,
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                photoPost = R.drawable.relog,
                reactions = "12.4 k",
                comments = "250"
            ),
            ModelPostCommunity(
                photo = R.drawable.img,
                name = "Noel Bermudez",
                timePost = "Hace 1 hora",
                options = R.drawable.opciones,
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                photoPost = R.drawable.relog,
                reactions = "12.4 k",
                comments = "250"
            )
        , ModelPostCommunity(
                photo = R.drawable.img,
                name = "Piter Floch",
                timePost = "Hace 1 hora",
                options = R.drawable.opciones,
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                photoPost = R.drawable.relog,
                reactions = "12.4 k",
                comments = "250"
            )
        , ModelPostCommunity(
                photo = R.drawable.img,
                name = "Jareth Moses",
                timePost = "Hace 1 hora",
                options = R.drawable.opciones,
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                photoPost = R.drawable.relog,
                reactions = "12.4 k",
                comments = "250"
            )
        )
    }
}