package com.codinginflow.imagesearchapp.gallery.data

import com.codinginflow.imagesearchapp.api.UnSplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnSplashRepository @Inject constructor(private val unspalshApi: UnSplashApi) {
}