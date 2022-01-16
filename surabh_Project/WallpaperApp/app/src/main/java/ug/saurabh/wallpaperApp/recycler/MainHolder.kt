package ug.saurabh.wallpaperApp.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.itme_design.view.*
import ug.saurabh.wallpaperApp.OnItemImage
import ug.saurabh.wallpaperApp.model.Photo

class MainHolder (val ItemView: View,val onItemImage: OnItemImage):RecyclerView.ViewHolder(ItemView) {

    fun setData(photo: Photo){

        ItemView.apply {
            Glide.with(TvImage).load(photo.src.portrait).into(TvImage)
        }

        ItemView.setOnClickListener {
            onItemImage.ImageClick(photo.src)
        }
    }
}