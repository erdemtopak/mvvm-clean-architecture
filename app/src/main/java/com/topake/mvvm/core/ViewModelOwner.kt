package com.topake.mvvm.core

interface ViewModelOwner {

    fun<T : BaseViewModel> getViewModel(id: Int, viewModelClass: Class<T>): T
}