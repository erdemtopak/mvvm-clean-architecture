package com.topake.mvvm.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.databinding.ActivityDetailBinding
import com.topake.mvvm.helper.NavigationWrapper

/**
 * Created by topake on 29/06/2017.
 */

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailActivityViewModel, DetailInteractor>() {

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
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.base_frame_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun getViewModelClass(): Class<out DetailActivityViewModel> {
        return DetailActivityViewModel::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_detail
    }

    override fun createInteractor(): DetailInteractor {
        return DetailInteractor(viewModel)
    }

}