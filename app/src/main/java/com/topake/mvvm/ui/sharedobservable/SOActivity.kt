package com.topake.mvvm.ui.sharedobservable

import android.os.Bundle
import android.support.v4.app.Fragment
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.core.ViewModelHolder
import com.topake.mvvm.databinding.ActivitySoBinding
import com.topake.mvvm.helper.NavigationWrapper

/**
 * Created by topake on 14/08/2017.
 */

class SOActivity : BaseActivity<ActivitySoBinding, SOActivityVM>() {

    companion object {
        fun createNavigationWrapper(): NavigationWrapper {
            return NavigationWrapper(null, SOActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(SOFragment())
    }

    override fun getViewModelClass(): Class<out SOActivityVM> {
        return SOActivityVM::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_so
    }


    override fun createViewModelHolder(): ViewModelHolder {
        return SOVMHolder(SOWrapper())
    }

}