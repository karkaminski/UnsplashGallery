package pl.karkaminski.unsplashgallery.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.databinding.ItemPhotoBinding
import java.lang.Exception

class PhotoAdapter(private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    var photoList = listOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        val photo = photoList[position]

        holder.binding.apply {
            usernameTextView.text = photo.user.name
            root.setOnClickListener {
                itemClickListener.onItemClicked(photo)
            }
            
        Picasso.get()
            .load(photo.urls.regular)
            .into(holder.binding.photoImageView, object : Callback {
                override fun onSuccess() {
                    holder.binding.linearLayout.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    holder.binding.linearLayout.visibility = View.GONE
                }
            })
        }
    }

    //////ViewHolder//////
    inner class PhotoViewHolder(val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface ItemClickListener {
        fun onItemClicked(photo: Photo)
    }
}