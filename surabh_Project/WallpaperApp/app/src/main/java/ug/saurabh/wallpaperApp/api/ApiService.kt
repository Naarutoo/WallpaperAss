package ug.saurabh.wallpaperApp.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ug.saurabh.wallpaperApp.model.ResponseDTO


interface ApiService {

    @GET("v1/search")
    fun getDataByApi(@Query("query") query:String,@Header("Authorization") Authorization:String):Observable<ResponseDTO>

}
//https://api.pexels.com/v1/search?query=people