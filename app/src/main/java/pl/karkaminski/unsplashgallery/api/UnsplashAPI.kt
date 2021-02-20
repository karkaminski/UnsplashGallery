package pl.karkaminski.unsplashgallery.api

import pl.karkaminski.unsplashgallery.BuildConfig
import pl.karkaminski.unsplashgallery.data.Topic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashAPI {

    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}")
    @GET("topics")
    fun getTopics() : Call<List<Topic>>


}