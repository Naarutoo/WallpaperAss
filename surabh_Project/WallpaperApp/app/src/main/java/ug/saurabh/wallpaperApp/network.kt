package ug.saurabh.wallpaperApp

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ug.saurabh.wallpaperApp.api.ApiService

object network {

    val base_url="https://api.pexels.com/"

    fun getDataByNetwork():ApiService {
        val retrofit = Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

        return retrofit.create(ApiService::class.java)
    }

}

//http://www.mocky.io/v2/5e2bebd23100007a00267e51
//Details - Names, Image URLs
//Videos - http://www.mocky.io/v2/5e2beb5a3100006600267e4e