package pl.karkaminski.unsplashgallery.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.data.Topic
import pl.karkaminski.unsplashgallery.databinding.GalleryFragmentBinding
import pl.karkaminski.unsplashgallery.ui.gallery.adapter.PhotoAdapter
import pl.karkaminski.unsplashgallery.ui.mainpager.MainPagerFragmentDirections

class GalleryFragment(private val topic: Topic) : Fragment(), PhotoAdapter.ItemClickListener {

    private val viewModel by viewModels<GalleryViewModel>()
    private var binding : GalleryFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = GalleryFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val photoAdapter = PhotoAdapter(this)

        fragmentBinding.apply {
            topicNameTextView.text = topic.title
            topicDescriptionTextView.text = topic.description
            photosRecyclerView.adapter = photoAdapter
        }

        viewModel.getTopicPhotos(topic).observe(viewLifecycleOwner,
            { list ->
                photoAdapter.apply {
                    if (list != null){
                        photoList = list
                        notifyDataSetChanged()
                    }
                }
            })

        return fragmentBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    //Photo ItemClickListener
    override fun onItemClicked(photo: Photo) {
        val action = MainPagerFragmentDirections.actionMainPagerFragmentToPhotoDetailsFragment(photo)
        findNavController().navigate(action)
    }
}