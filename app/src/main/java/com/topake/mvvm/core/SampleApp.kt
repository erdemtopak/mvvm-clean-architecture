package com.topake.mvvm.core

import android.app.Activity
import android.app.Application
import android.content.Context
import com.topake.mvvm.BuildConfig
import com.topake.mvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by topake on 28/06/2017.
 */

class SampleApp : Application(), HasActivityInjector {

    companion object {
        lateinit var instance: Context
        fun getAppContext() = instance
    }

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}