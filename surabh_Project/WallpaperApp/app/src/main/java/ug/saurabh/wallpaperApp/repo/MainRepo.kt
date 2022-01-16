package ug.saurabh.wallpaperApp.repo

import io.reactivex.rxjava3.core.Observable
import ug.saurabh.wallpaperApp.model.ResponseDTO

import ug.saurabh.wallpaperApp.network

class MainRepo {

    fun getDataByRepo(Query:String,Key:String):Observable<ResponseDTO>{
        return network.getDataByNetwork().getDataByApi(Query,Key)
    }

}