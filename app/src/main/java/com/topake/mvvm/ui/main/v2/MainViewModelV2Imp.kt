package com.topake.mvvm.ui.main.v1

import android.databinding.ObservableField
import android.view.View
import android.widget.Toast
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseViewModel
import com.topake.mvvm.core.SampleApp
import com.topake.mvvm.helper.ResourceHelper
import com.topake.mvvm.ui.detail.DetailActivity
import com.topake.mvvm.ui.main.v2.MainViewModelV2

/**
 * Created by topake on 06/07/2017.
 */
class MainViewModelV2Imp : BaseViewModel(), MainViewModelV2 {

    override var countText: ObservableField<String> = ObservableField()
    override var countValue: Int = 0

    override fun increaseClick(view: android.view.View) {
        countValue++
        countText.set(countValue.toString())
        val a = ResourceHelper.Companion.getString(R.string.dummy_text)
        Toast.makeText(SampleApp.getAppContext(), a, Toast.LENGTH_LONG).show()
    }

    override fun detailClick(view: View) {
        navigationState.set(DetailActivity.createNavigationWrapper("foo"))
    }

}