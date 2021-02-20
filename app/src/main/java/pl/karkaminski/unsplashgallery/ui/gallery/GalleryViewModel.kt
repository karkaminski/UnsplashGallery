package pl.karkaminski.unsplashgallery.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.karkaminski.unsplashgallery.api.UnsplashRepository
import pl.karkaminski.unsplashgallery.data.Topic

class GalleryViewModel : ViewModel() {

    private val unsplashRepository = UnsplashRepository()

    var topicList = MutableLiveData<List<Topic>>()

    init {
        getTopicList()
    }

    private fun getTopicList() {
        topicList = unsplashRepository.getTopics()
    }

}