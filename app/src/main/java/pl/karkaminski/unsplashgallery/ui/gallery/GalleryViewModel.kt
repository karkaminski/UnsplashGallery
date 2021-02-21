package pl.karkaminski.unsplashgallery.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.karkaminski.unsplashgallery.api.UnsplashRepository
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.data.Topic

class GalleryViewModel : ViewModel() {

    private val unsplashRepository = UnsplashRepository()

    var topicList = MutableLiveData<List<Topic>>()
    var topicPhotos = MutableLiveData<List<Photo>>()

    init {
        getTopicsList()
        getTopicPhotos()
    }

    private fun getTopicsList() {
        topicList = unsplashRepository.getTopics()
    }

    private fun getTopicPhotos() {
        topicPhotos = unsplashRepository.getTopicPhotos()
    }

}