package pl.karkaminski.unsplashgallery.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.data.Topic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UnsplashRepository {

    var unsplashAPI: UnsplashAPI

    companion object {
        private const val TAG = "UnsplashRepository"
        const val BASE_URL = "https://api.unsplash.com"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        unsplashAPI = retrofit.create(UnsplashAPI::class.java)
    }

    fun getTopics(): MutableLiveData<List<Topic>> {
        var list = MutableLiveData<List<Topic>>()
        unsplashAPI.getTopics()
            .enqueue(object : Callback<List<Topic>> {
                override fun onResponse(call: Call<List<Topic>>, response: Response<List<Topic>>) {
                    list.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Topic>>, t: Throwable) {
                    Log.i(TAG, "onFailure: " + t.message)
                }

            })
        return list
    }

    fun getTopicPhotos(): MutableLiveData<List<Photo>> {
        var list = MutableLiveData<List<Photo>>()

        unsplashAPI.getTopicPhotos()
            .enqueue(object : Callback<List<Photo>> {
                override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                    list.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                    Log.i(TAG, "onFailure: " + t.message)
                }
            })

        return list
    }
}