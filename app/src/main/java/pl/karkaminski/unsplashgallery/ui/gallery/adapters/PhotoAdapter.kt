package pl.karkaminski.unsplashgallery.ui.gallery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pl.karkaminski.unsplashgallery.data.Photo
import pl.karkaminski.unsplashgallery.databinding.ItemPhotoBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    var photoList = listOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        val photo = photoList[position]

        holder.binding.apply {
            if (photo.description != null) {
                descriptionTextView.visibility = View.VISIBLE
                descriptionTextView.text = photo.description
            }
            usernameTextView.text = photo.user.name
        }

        Picasso.get()
            .load(photo.urls.regular)
            .into(holder.binding.photoImageView)
    }

    inner class PhotoViewHolder(val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}