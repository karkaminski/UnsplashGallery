package pl.karkaminski.unsplashgallery.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.karkaminski.unsplashgallery.api.UnsplashRepository
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.data.Topic

class GalleryViewModel : ViewModel() {

    private val unsplashRepository = UnsplashRepository()

    fun getTopicPhotos (topic: Topic) : MutableLiveData<List<Photo>> {
        return unsplashRepository.getTopicPhotos(topic.id)
    }
}