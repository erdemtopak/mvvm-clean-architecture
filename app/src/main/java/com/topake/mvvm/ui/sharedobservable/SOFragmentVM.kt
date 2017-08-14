package com.topake.mvvm.ui.sharedobservable

import android.databinding.ObservableField
import android.view.View
import com.topake.mvvm.core.BaseViewModel

class SOFragmentVM(val SOWrapper: SOWrapper) : BaseViewModel(), SOHolder {

    val text : ObservableField<String> = ObservableField()

    fun onSetTextClick(view : View) {
        SOWrapper.title.set(text.get())
    }

}