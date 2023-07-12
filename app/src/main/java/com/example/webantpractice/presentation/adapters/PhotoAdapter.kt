package com.example.webantpractice.presentation.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.webantpractice.R
import com.example.webantpractice.core.Constants
import com.example.webantpractice.domain.model.PhotoItem

class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var photoImage: ImageView = itemView.findViewById<ImageView>(R.id.gallery_photo_iv)
    }

    private val differCallback = object : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_photo_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photoItem = differ.currentList[position]

        //TODO()
        //Problems with Webant API? Need to change this lines
        val element = Constants.sample_images.random()

        holder.photoImage.setImageResource(element)
    }
}