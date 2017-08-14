package com.topake.mvvm.ui.main.v1

import android.os.Bundle
import android.widget.Toast
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.databinding.ActivityMainV2Binding
import com.topake.mvvm.helper.DummyHelper
import javax.inject.Inject

class MainActivityV2 : BaseActivity<ActivityMainV2Binding, MainViewModelV1>() {

    @Inject lateinit var dummyHelper: DummyHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, dummyHelper.get(), Toast.LENGTH_SHORT).show()
    }

    override fun getViewModelClass(): Class<out MainViewModelV1> {
        return MainViewModelV1::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main_v1
    }
}
