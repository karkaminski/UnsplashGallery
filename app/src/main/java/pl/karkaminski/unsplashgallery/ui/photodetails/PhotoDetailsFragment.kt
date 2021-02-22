package pl.karkaminski.unsplashgallery.ui.photodetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import pl.karkaminski.unsplashgallery.R
import pl.karkaminski.unsplashgallery.databinding.PhotoDetailsFragmentBinding
import pl.karkaminski.unsplashgallery.ui.gallery.GalleryViewModel

class PhotoDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = PhotoDetailsFragment()
    }

    private val viewModel by viewModels<PhotoDetailsViewModel>()
    private var binding : PhotoDetailsFragmentBinding? = null

    val args : PhotoDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = PhotoDetailsFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val photo = args.photo

        fragmentBinding.apply {
            usernameTextView.text = photo.user.name
            userIdTextView.text = photo.user.username
            descriptionTextView.text = photo.description
        }

        Picasso.get()
            .load(photo.urls.regular)
            .into(fragmentBinding.photoImageView)

        return fragmentBinding.root
    }


}