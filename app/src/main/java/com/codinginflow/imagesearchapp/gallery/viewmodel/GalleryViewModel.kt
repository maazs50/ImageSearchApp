package com.codinginflow.imagesearchapp.gallery.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.codinginflow.imagesearchapp.gallery.data.UnSplashRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnSplashRepository,
    @Assisted state: SavedStateHandle)
    : ViewModel() {
        companion object{
            const val DEFAULT_QUERY = "cats"
            const val CURRENT_QUERY = "current_query"
        }

        private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

        val photos = currentQuery.switchMap { queryString ->
           repository.getSearchResults(queryString).cachedIn(viewModelScope)
        }

        fun searchPhotos(query: String){
            currentQuery.value = query
        }
}