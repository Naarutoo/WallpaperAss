package ug.saurabh.wallpaperApp.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ug.saurabh.wallpaperApp.OnItemImage
import ug.saurabh.wallpaperApp.R
import ug.saurabh.wallpaperApp.model.ResponseDTO

class MainAdapter(val responseDTO: ResponseDTO,val Clicklistener:OnItemImage):RecyclerView.Adapter<MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MainHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.itme_design,parent,false)
        return MainHolder(view,Clicklistener)
    }

    override fun onBindViewHolder(holder: MainHolder, p1: Int) {
        val result=responseDTO.photos[p1]
        holder.setData(result)
    }

    override fun getItemCount(): Int {
        return responseDTO.photos.size
    }
}