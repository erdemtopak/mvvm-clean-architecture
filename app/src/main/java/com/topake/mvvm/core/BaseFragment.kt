package com.topake.mvvm.core

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.topake.mvvm.BR
import com.topake.mvvm.helper.NavigationHelper
import com.topake.mvvm.util.onPropertyChangedAutoClear

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    lateinit var navigationHelper: NavigationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationHelper()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initViewModel()
        return setContentView(inflater, container, getLayoutResId())
    }

    protected fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        viewModel.navigationState.onPropertyChangedAutoClear(this) { navigationHelper.navigate(it) }
    }

    protected fun setContentView(inflater: LayoutInflater?,
                                 container: ViewGroup?,
                                 @LayoutRes layoutResID: Int): View {
        binding = DataBindingUtil.inflate<B>(inflater, layoutResID, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    protected fun initNavigationHelper() {
        navigationHelper = NavigationHelper(context, childFragmentManager)
    }

    protected abstract fun getViewModelClass(): Class<out VM>

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

}
