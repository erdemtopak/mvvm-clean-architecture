package com.topake.mvvm.ui.main.v1

import android.databinding.ObservableField
import android.view.View
import android.widget.Toast
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseViewModel
import com.topake.mvvm.core.SampleApp
import com.topake.mvvm.helper.ResourceHelper
import com.topake.mvvm.ui.detail.DetailActivity

/**
 * Created by topake on 06/07/2017.
 */
class MainViewModelV1 : BaseViewModel() {

    var countText: ObservableField<String> = ObservableField()
    var countValue = 0

    fun increaseClick(view: View) {
        countValue++
        countText.set(countValue.toString())
        val a = ResourceHelper.getString(R.string.dummy_text)
        Toast.makeText(SampleApp.getAppContext(), a, Toast.LENGTH_LONG).show()
    }

    fun detailClick(view: View) {
        navigationState.set(DetailActivity.createNavigationWrapper("foo"))
    }

}