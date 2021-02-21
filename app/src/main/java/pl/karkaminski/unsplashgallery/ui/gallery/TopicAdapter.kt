package pl.karkaminski.unsplashgallery.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.karkaminski.unsplashgallery.data.Topic
import pl.karkaminski.unsplashgallery.databinding.ItemTopicBinding

class TopicAdapter :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    var topicList = listOf<Topic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = ItemTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicViewHolder(binding)
    }

    override fun getItemCount() = topicList.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.binding.textView.text = topicList[position].title
    }

    //////ViewHolder//////
    inner class TopicViewHolder(val binding: ItemTopicBinding) :
        RecyclerView.ViewHolder(binding.root)
}