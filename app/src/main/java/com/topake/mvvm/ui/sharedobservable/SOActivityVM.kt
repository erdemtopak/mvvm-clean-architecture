package com.topake.mvvm.ui.sharedobservable

import android.databinding.ObservableField
import com.topake.mvvm.core.BaseViewModel
import com.topake.mvvm.util.onPropertyChanged

class SOActivityVM(soWrapper: SOWrapper) : BaseViewModel(), SOHolder {

    init {
        soWrapper.title.onPropertyChanged { title.set(it) }
    }

    val title : ObservableField<String> = ObservableField("")
}