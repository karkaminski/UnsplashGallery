package pl.karkaminski.unsplashgallery.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import pl.karkaminski.unsplashgallery.databinding.GalleryFragmentBinding

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private val viewModel by viewModels<GalleryViewModel>()
    private var binding : GalleryFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = GalleryFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding


        val topicAdapter = TopicAdapter()
        fragmentBinding.topicsRecyclerView.adapter = topicAdapter
        viewModel.topicList.observe(viewLifecycleOwner,
            { list ->
                topicAdapter.apply {
                    if (list != null){
                        topicList = list
                        notifyDataSetChanged()
                    }
                }
            })

        val photoAdapter = PhotoAdapter()
        fragmentBinding.photosRecyclerView.adapter = photoAdapter
        viewModel.topicPhotos.observe(viewLifecycleOwner,
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

}