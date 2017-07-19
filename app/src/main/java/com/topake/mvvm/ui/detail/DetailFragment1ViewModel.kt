package com.topake.mvvm.ui.detail

import android.databinding.ObservableBoolean
import android.view.View
import com.topake.mvvm.core.BaseViewModel
import com.topake.mvvm.helper.NavigationWrapper

class DetailFragment1ViewModel : BaseViewModel() {

    interface DetailFragment1ViewModelHolder {
        fun register(vm : DetailFragment1ViewModel)
    }

    var checkStatus  = ObservableBoolean()

    fun onNextPageClick(view: View) {
        navigationState.set(NavigationWrapper(DetailFragment2()))
    }
}