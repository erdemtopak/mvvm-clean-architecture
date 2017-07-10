package com.topake.mvvm.core

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.topake.mvvm.helper.NavigationWrapper

/**
 * Created by topake on 06/07/2017.
 */

open class BaseViewModel : ViewModel() {

    var navigationState = ObservableField<NavigationWrapper>()
}