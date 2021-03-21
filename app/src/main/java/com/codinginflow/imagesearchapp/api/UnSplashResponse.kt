package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.gallery.data.UnsplashPhoto

data class UnSplashResponse(
    val results: List<UnsplashPhoto>
)