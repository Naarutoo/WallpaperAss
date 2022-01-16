package ug.saurabh.wallpaperApp.main_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ug.saurabh.wallpaperApp.MainUiModel
import ug.saurabh.wallpaperApp.model.ResponseDTO

import ug.saurabh.wallpaperApp.repo.MainRepo
class MainViewmodel :ViewModel() {

   private val repo=MainRepo()

    private val mutableLiveData = MutableLiveData<MainUiModel>()

    val liveData: LiveData<MainUiModel> = mutableLiveData

   private lateinit var disposable: Disposable

    fun getDataByViewmodel(query:String,Key:String){
        repo.getDataByRepo(query,Key).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(object :Observer<ResponseDTO>{
            override fun onSubscribe(d: Disposable) {
                disposable=d
            }

            override fun onNext(t: ResponseDTO) {
                mutableLiveData.postValue(MainUiModel.Onsucess(t))
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

        })


    }
}