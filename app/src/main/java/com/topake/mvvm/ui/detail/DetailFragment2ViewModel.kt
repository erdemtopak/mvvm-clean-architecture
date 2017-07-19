package com.topake.mvvm.ui.detail

import android.databinding.ObservableBoolean
import android.view.View
import com.topake.mvvm.core.BaseViewModel
import com.topake.mvvm.helper.NavigationState
import com.topake.mvvm.helper.NavigationWrapper

class DetailFragment2ViewModel : BaseViewModel() {

    val approvedState = ObservableBoolean(false)

    interface DetailFragment2ViewModelHolder {
        fun register(vm : DetailFragment2ViewModel)
    }

    fun onPreviousPageClick(view: View) {
        approvedState.set(true)
        navigationState.set(NavigationWrapper(NavigationState.BACK))
    }
}