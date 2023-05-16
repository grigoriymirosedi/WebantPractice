package com.example.webantpractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.webantpractice.R
import com.example.webantpractice.models.GalleryPhotoItem

class UserProfileGalleryAdapter(private val userGalleryPhotoList: List<GalleryPhotoItem>): RecyclerView.Adapter<UserProfileGalleryAdapter.UserProfileGalleryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserProfileGalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_gallery_photo_item, parent, false)
        return UserProfileGalleryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userGalleryPhotoList.size
    }

    override fun onBindViewHolder(viewHolder: UserProfileGalleryViewHolder, position: Int) {
        val userGalleryPhotoItem = userGalleryPhotoList[position]
        viewHolder.userProfileImage.setImageResource(userGalleryPhotoItem.photoURL)
    }

    class UserProfileGalleryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userProfileImage: ImageView = view.findViewById(R.id.user_gallery_photo_iv)
    }
}