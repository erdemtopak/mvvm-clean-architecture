package com.topake.mvvm.core

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class SimpleActivityLifecycleCallback : Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }
}