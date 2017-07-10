package com.topake.mvvm.ui.main.v2

import android.databinding.ObservableField
import android.view.View

interface MainViewModelV2 {

    var countText: ObservableField<String>
    var countValue: Int

    fun increaseClick(view: View)
    fun detailClick(view: View)
}
