package com.topake.mvvm.core

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

    protected val uniqueIdDelegate = UniqueIdDelegate()
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    lateinit var navigationHelper: NavigationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uniqueIdDelegate.generate(this, savedInstanceState)
        initNavigationHelper()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initViewModel()
        return setContentView(inflater, container, getLayoutResId())
    }

    protected fun initViewModel() {
        if (ViewModelOwner::class.java.isAssignableFrom(activity.javaClass)) {
            viewModel = (activity as ViewModelOwner).getViewModel(getUniqueId(), getViewModelClass())
            viewModel.navigationState.onPropertyChangedAutoClear(this) { navigationHelper.navigate(it) }
        } else{
            throw RuntimeException("Activity must be implement ViewModelOwner")
        }
    }

    protected fun setContentView(inflater: LayoutInflater?,
                                 container: ViewGroup?,
                                 @LayoutRes layoutResID: Int): View {
        binding = DataBindingUtil.inflate<B>(inflater, layoutResID, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        registerViewModel()
        return binding.root
    }

    protected fun initNavigationHelper() {
        navigationHelper = NavigationHelper(activity, fragmentManager)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        uniqueIdDelegate.saveState(outState)
    }

    protected fun getUniqueId() = uniqueIdDelegate.uniqueId

    protected abstract fun getViewModelClass(): Class<out VM>

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    protected abstract fun registerViewModel()

}
