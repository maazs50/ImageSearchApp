package com.codinginflow.imagesearchapp.gallery.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codinginflow.imagesearchapp.gallery.data.UnSplashRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnSplashRepository)
    : ViewModel() {
        companion object{
            const val DEFAULT_QUERY = "cats"
        }

        private val currentQuery = MutableLiveData(DEFAULT_QUERY)

        val photos = currentQuery.switchMap { queryString ->
           repository.getSearchResults(queryString).cachedIn(viewModelScope)
        }

        fun searchPhotos(query: String){
            currentQuery.value = query
        }
}