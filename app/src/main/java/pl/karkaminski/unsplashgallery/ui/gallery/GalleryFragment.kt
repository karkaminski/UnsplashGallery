package pl.karkaminski.unsplashgallery.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import pl.karkaminski.unsplashgallery.data.Topic
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

        val adapter = TopicAdapter()
        fragmentBinding.topicsRecyclerView.adapter = adapter

        viewModel.topicList.observe(viewLifecycleOwner,
            { list ->
                adapter.apply {
                    if (list != null){
                        topicList = list
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