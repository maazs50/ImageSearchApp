package com.codinginflow.imagesearchapp.gallery.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.codinginflow.imagesearchapp.api.UnSplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnSplashRepository @Inject constructor(private val unspalshApi: UnSplashApi) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unspalshApi, query)}
        ).liveData
}