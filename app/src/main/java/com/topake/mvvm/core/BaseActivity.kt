package com.topake.mvvm.core

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity
import com.topake.mvvm.BR
import com.topake.mvvm.helper.NavigationHelper
import com.topake.mvvm.util.onPropertyChanged
import dagger.android.AndroidInjection


/**
 * Created by topake on 29/06/2017.
 */

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : FragmentActivity() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    lateinit var navigationHelper: NavigationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initNavigationHelper()
        initViewModel()
        setAndBindContentView()
    }

    protected fun initNavigationHelper() {
        navigationHelper = NavigationHelper(this, supportFragmentManager)
    }

    protected fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        viewModel.navigationState.onPropertyChanged { navigationHelper.navigate(it) }
    }

    protected fun setAndBindContentView() {
        binding = DataBindingUtil.setContentView<B>(this, getLayoutResId())
        binding.setVariable(BR.viewModel, viewModel)
    }

    protected abstract fun getViewModelClass(): Class<out VM>

    @LayoutRes
    protected abstract fun getLayoutResId(): Int
}
