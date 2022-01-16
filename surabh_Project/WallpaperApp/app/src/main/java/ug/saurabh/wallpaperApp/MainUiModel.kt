package ug.saurabh.wallpaperApp

import ug.saurabh.wallpaperApp.model.ResponseDTO


sealed class MainUiModel{

    data class Onsucess(val responseDTO: ResponseDTO):MainUiModel()

    data class OnError(val error:String):MainUiModel()

}
