package pl.karkaminski.unsplashgallery.ui.mainpager

import androidx.lifecycle.ViewModel
import pl.karkaminski.unsplashgallery.api.UnsplashRepository

class MainPagerViewModel : ViewModel() {
    
    private val unsplashRepository = UnsplashRepository()

    var topicList = unsplashRepository.getTopics()

}