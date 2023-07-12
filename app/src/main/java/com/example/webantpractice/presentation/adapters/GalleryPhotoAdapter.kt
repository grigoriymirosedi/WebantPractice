package com.example.webantpractice.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.webantpractice.presentation.models.GalleryPhotoItem
import com.example.webantpractice.R

class GalleryPhotoAdapter(private val galleryPhotoList: List<GalleryPhotoItem>): RecyclerView.Adapter<GalleryPhotoAdapter.GalleryPhotoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryPhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_photo_item, parent, false)
        return GalleryPhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return galleryPhotoList.size
    }

    override fun onBindViewHolder(viewHolder: GalleryPhotoViewHolder, position: Int) {
        var galleryPhotoItem = galleryPhotoList[position]
        viewHolder.galleryPhotoImage.setImageResource(galleryPhotoItem.photoURL)
    }

    class GalleryPhotoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val galleryPhotoImage: ImageView = view.findViewById(R.id.gallery_photo_iv)
    }
}