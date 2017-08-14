package com.topake.mvvm.ui.detail

import android.os.Bundle
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.databinding.ActivityDetailBinding
import com.topake.mvvm.helper.NavigationWrapper

/**
 * Created by topake on 29/06/2017.
 */

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailActivityViewModel>() {

    companion object {
        val KEY_DUMMY_TEXT = "KEY_DUMMY_TEXT"

        fun createNavigationWrapper(dummyText: String): NavigationWrapper {
            val bundle = Bundle()
            bundle.putString(KEY_DUMMY_TEXT, dummyText)
            return NavigationWrapper(bundle, DetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(DetailFragment1())
        vmInteractor = DetailInteractor(viewModel)
    }

    override fun getViewModelClass(): Class<out DetailActivityViewModel> {
        return DetailActivityViewModel::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_detail
    }

}