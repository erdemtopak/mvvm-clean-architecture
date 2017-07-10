package com.topake.mvvm.ui.main.v1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import butterknife.bindView
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.databinding.ActivityMainV2Binding
import com.topake.mvvm.helper.DummyHelper
import com.topake.mvvm.ui.detail.DetailActivity
import javax.inject.Inject

class MainActivityV2 : BaseActivity<ActivityMainV2Binding, MainViewModelV1>() {

    @Inject lateinit var dummyHelper: DummyHelper

    val buttonDetail: Button by bindView(R.id.main_button_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, dummyHelper.get(), Toast.LENGTH_SHORT).show()
        buttonDetail.setOnClickListener({ startActivity(Intent(this, DetailActivity::class.java)) })
    }

    override fun getViewModelClass(): Class<out MainViewModelV1> {
        return MainViewModelV1::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main_v1
    }
}
