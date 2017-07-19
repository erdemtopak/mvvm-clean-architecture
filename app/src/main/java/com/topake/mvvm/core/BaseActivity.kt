package com.topake.mvvm.core

import android.app.Application
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.topake.mvvm.BR
import com.topake.mvvm.helper.NavigationHelper
import com.topake.mvvm.util.onPropertyChangedAutoClear
import dagger.android.AndroidInjection


/**
 * Created by topake on 29/06/2017.
 */

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel, I: BaseInteractor> : FragmentActivity(),
        ViewModelOwner, InteractorOwner<I> {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected lateinit var vmInteractor : I

    lateinit var navigationHelper: NavigationHelper

    val lifecycleDelegate = ActivityLifecycleDelegate()
    val uniqueIdDelegate = UniqueIdDelegate()
    val viewModelHolder = ViewModelHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        uniqueIdDelegate.generate(this, savedInstanceState)
        lifecycleDelegate.onActivityCreated(this, savedInstanceState)
        initNavigationHelper()
        initViewModel()
        setAndBindContentView()
        vmInteractor = createInteractor()
    }

    protected fun initNavigationHelper() {
        navigationHelper = NavigationHelper(this, supportFragmentManager)
    }

    protected fun initViewModel() {
        viewModel = viewModelHolder.getViewModel(getId(), getViewModelClass())
//        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        viewModel.navigationState.onPropertyChangedAutoClear(this) { navigationHelper.navigate(it) }
    }

    protected fun setAndBindContentView() {
        binding = DataBindingUtil.setContentView<B>(this, getLayoutResId())
        binding.setVariable(BR.viewModel, viewModel)
    }

    fun registerLifecycleCallback(lifecycleCallback: Application.ActivityLifecycleCallbacks) {
        Log.d("##register", lifecycleCallback.toString())
        lifecycleDelegate.registerLifecycleListener(lifecycleCallback)
    }

    fun unRegisterLifecycleCallback(lifecycleCallback: Application.ActivityLifecycleCallbacks) {
        Log.d("##unregister", lifecycleCallback.toString())
        lifecycleDelegate.unRegisterLifecycleListener(lifecycleCallback)
    }

    protected fun getId() = uniqueIdDelegate.uniqueId

    override fun onStart() {
        super.onStart()
        lifecycleDelegate.onActivityStarted(this)
    }

    override fun onResume() {
        super.onResume()
        lifecycleDelegate.onActivityResumed(this)
    }

    override fun onPause() {
        super.onPause()
        lifecycleDelegate.onActivityPaused(this)
    }

    override fun onStop() {
        super.onStop()
        lifecycleDelegate.onActivityPaused(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        lifecycleDelegate.onActivitySaveInstanceState(this, outState)
        uniqueIdDelegate.saveState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleDelegate.onActivityDestroyed(this)
    }

    override fun <T : BaseViewModel> getViewModel(id: Int, viewModelClass: Class<T>): T {
        return viewModelHolder.getViewModel(id, viewModelClass)
    }

    override fun getInteractor(): I {
        return vmInteractor
    }

    protected abstract fun getViewModelClass(): Class<out VM>

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    protected abstract fun createInteractor() : I

}
