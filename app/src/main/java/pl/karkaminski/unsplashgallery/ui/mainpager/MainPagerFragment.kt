package pl.karkaminski.unsplashgallery.ui.mainpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import pl.karkaminski.unsplashgallery.data.Topic
import pl.karkaminski.unsplashgallery.databinding.MainPagerFragmentBinding
import pl.karkaminski.unsplashgallery.ui.gallery.GalleryFragment

class MainPagerFragment : Fragment() {

    private val viewModel by viewModels<MainPagerViewModel>()
    private lateinit var binding: MainPagerFragmentBinding
    private var topicList = listOf<Topic>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = MainPagerFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val pagerAdapter = GalleryPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        viewModel.topicList.observe(viewLifecycleOwner,
            { listOfTopics ->
                topicList = listOfTopics
                pagerAdapter.apply {
                    topicList = listOfTopics
                    notifyDataSetChanged()
                }
            })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {
            tab, position ->
            tab.text = topicList[position].title
        }.attach()
    }

    private inner class GalleryPagerAdapter(fragment: Fragment) :
        FragmentStateAdapter(fragment) {

        var topicList = listOf<Topic>()

        override fun getItemCount() = topicList.size

        override fun createFragment(position: Int) = GalleryFragment(topicList[position])
    }
}