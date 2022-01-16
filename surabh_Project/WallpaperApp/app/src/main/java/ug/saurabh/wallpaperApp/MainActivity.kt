package ug.saurabh.wallpaperApp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ug.saurabh.wallpaperApp.main_viewmodel.MainViewmodel
import ug.saurabh.wallpaperApp.model.ResponseDTO
import ug.saurabh.wallpaperApp.model.Src
import ug.saurabh.wallpaperApp.recycler.MainAdapter

class MainActivity : AppCompatActivity(),OnItemImage{

    lateinit var mainAdapter: MainAdapter
    var response:ResponseDTO?=null

    var mainViewmodel=MainViewmodel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewmodel= ViewModelProvider(this).get(MainViewmodel::class.java)

        TvBtn.setOnClickListener {
            callapi()
        }


    }

    private fun callapi() {
        mainViewmodel.getDataByViewmodel(TvSearch.text.toString(),"563492ad6f917000010000015d61d36010d64c058fc87f8e9ec17321")
        mainViewmodel.liveData.observe(this,{
            when(it){
                is MainUiModel.Onsucess ->{
                    Log.d("umang", it.responseDTO.photos.toString())
                    response=it.responseDTO
                    setRecycler()
                }

                is MainUiModel.OnError->{
                    Log.d("umang",it.error)
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecycler() {
        mainAdapter= MainAdapter(response!!,this)
        recycler.layoutManager=GridLayoutManager(this,2)
        recycler.adapter=mainAdapter
        mainAdapter.notifyDataSetChanged()
    }

    override fun ImageClick(src: Src) {
       val intent= Intent(this,SecondImage::class.java)
       intent.putExtra("image",src.original)
       startActivity(intent)
    }


}