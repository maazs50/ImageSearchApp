package com.codinginflow.imagesearchapp.gallery.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.codinginflow.imagesearchapp.gallery.data.UnSplashRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnSplashRepository)
    : ViewModel() {
}