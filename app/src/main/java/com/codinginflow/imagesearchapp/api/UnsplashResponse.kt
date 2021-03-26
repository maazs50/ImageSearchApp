package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.gallery.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)