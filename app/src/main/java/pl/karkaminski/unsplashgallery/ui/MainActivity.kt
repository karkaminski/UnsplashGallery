package pl.karkaminski.unsplashgallery.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import pl.karkaminski.unsplashgallery.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}