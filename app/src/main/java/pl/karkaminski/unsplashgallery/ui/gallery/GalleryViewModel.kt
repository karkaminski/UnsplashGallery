package pl.karkaminski.unsplashgallery.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import pl.karkaminski.unsplashgallery.api.UnsplashRepository
import pl.karkaminski.unsplashgallery.data.Topic

class GalleryViewModel : ViewModel() {

    private val unsplashRepository = UnsplashRepository()

    var currentTopicId = MutableLiveData("bo8jQKTaE0Y")

    var topicList = unsplashRepository.getTopics()
    var currentTopic = MutableLiveData<Topic>(topicList.value?.get(0))

    var topicPhotos = currentTopicId.switchMap { topicId ->
        unsplashRepository.getTopicPhotos(topicId)
    }

    fun switchTopic(topic:Topic){
        currentTopicId.value = topic.id
        currentTopic.value = topic
    }
}