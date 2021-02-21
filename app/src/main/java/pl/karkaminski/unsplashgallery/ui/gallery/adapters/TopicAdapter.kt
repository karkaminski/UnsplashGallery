package pl.karkaminski.unsplashgallery.ui.gallery.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.karkaminski.unsplashgallery.data.Topic
import pl.karkaminski.unsplashgallery.databinding.ItemTopicBinding

class TopicAdapter(private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    var topicList = listOf<Topic>()
    var selectedTopic = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = ItemTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicViewHolder(binding)
    }

    override fun getItemCount() = topicList.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topicList[position]

        holder.binding.textView.text = topic.title
        holder.binding.root.setOnClickListener {
            itemClickListener.onItemClicked(topic)
            selectedTopic = position
            notifyDataSetChanged()
        }

        holder.binding.textView.let {
            if (position == selectedTopic) it.setTextColor(Color.RED) else it.setTextColor(Color.BLUE)
        }

    }

    //////ViewHolder//////
    inner class TopicViewHolder(val binding: ItemTopicBinding) :
        RecyclerView.ViewHolder(binding.root)

    /////ItemClickListener/////
    interface ItemClickListener {
        fun onItemClicked(topic: Topic)
    }
}