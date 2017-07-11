package com.topake.mvvm.core

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityLifecycleDelegate {

    val lifecycleListeners = ArrayList<Application.ActivityLifecycleCallbacks>()

    fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        for (listener in lifecycleListeners) {
            listener.onActivityCreated(activity, savedInstanceState)
        }
    }

    fun onActivityStarted(activity: Activity) {
        for (listener in lifecycleListeners) {
            listener.onActivityStarted(activity)
        }
    }

    fun onActivityResumed(activity: Activity) {
        for (listener in lifecycleListeners) {
            listener.onActivityResumed(activity)
        }
    }

    fun onActivityPaused(activity: Activity) {
        for (listener in lifecycleListeners) {
            listener.onActivityPaused(activity)
        }
    }

    fun onActivityStopped(activity: Activity) {
        for (listener in lifecycleListeners) {
            listener.onActivityStopped(activity)
        }
    }

    fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
        for (listener in lifecycleListeners) {
            listener.onActivitySaveInstanceState(activity, outState)
        }
    }

    fun onActivityDestroyed(activity: Activity) {
        for (listener in lifecycleListeners) {
            listener.onActivityDestroyed(activity)
        }
    }

    fun registerLifecycleListener(listener: Application.ActivityLifecycleCallbacks) {
        lifecycleListeners.add(listener)
    }

    fun unRegisterLifecycleListener(listener: Application.ActivityLifecycleCallbacks) {
        lifecycleListeners.remove(listener)
    }
}