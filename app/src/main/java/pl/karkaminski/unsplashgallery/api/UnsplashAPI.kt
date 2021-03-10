package pl.karkaminski.unsplashgallery.api

import pl.karkaminski.unsplashgallery.BuildConfig
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.data.Topic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface UnsplashAPI {

    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}")
    @GET("/topics")
    fun getTopics() : Call<List<Topic>>

    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}")
    @GET("/topics/{topicId}/photos") //TODO hardcoded Wallpapers topic
    fun getTopicPhotos(@Path ("topicId") topicId : String) : Call<List<Photo>>


}