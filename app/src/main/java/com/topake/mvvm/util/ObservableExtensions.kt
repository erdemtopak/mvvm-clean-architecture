package com.topake.mvvm.util

import android.app.Activity
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.core.SimpleActivityLifecycleCallback


inline fun ObservableBoolean.onPropertyChanged(crossinline listener: (newValue: Boolean) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            listener(get())
        }
    })
}

inline fun <T> ObservableField<T>.onPropertyChanged(crossinline listener: (newValue: T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            listener(get())
        }
    })
}

inline fun <T> ObservableField<T>.onPropertyChangedAutoClear(
        activity: BaseActivity<*, *, *>, crossinline listener: (newValue: T) -> Unit) {

    val propertyCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            listener(get())
        }
    }
    addOnPropertyChangedCallback(propertyCallback)

    val lifecycleCallback = object : SimpleActivityLifecycleCallback() {
        override fun onActivityDestroyed(activity: Activity?) {
            removeOnPropertyChangedCallback(propertyCallback)
            (activity as BaseActivity<*, *, *>).unRegisterLifecycleCallback(this)
        }
    }

    activity.registerLifecycleCallback(lifecycleCallback)

}

//TODO will be tested
inline fun <T> ObservableField<T>.onPropertyChangedAutoClear(
        fragment: Fragment, crossinline listener: (newValue: T) -> Unit) {

    val propertyCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            listener(get())
        }
    }
    addOnPropertyChangedCallback(propertyCallback)

    val fragmentManager = fragment.fragmentManager
    fragmentManager.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    removeOnPropertyChangedCallback(propertyCallback)
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this)
                }
            }, false)
}