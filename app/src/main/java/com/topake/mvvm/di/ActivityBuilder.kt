package com.topake.mvvm.di

import com.topake.mvvm.ui.detail.DetailActivity
import com.topake.mvvm.ui.detail.DetailActivityModule
import com.topake.mvvm.ui.main.v1.*
import com.topake.mvvm.ui.sharedobservable.SOActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by topake on 29/06/2017.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModuleV1::class))
    abstract fun bindMainActivityV1(): MainActivityV1

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModuleV2::class))
    abstract fun bindMainActivityV2(): MainActivityV2

    @ContributesAndroidInjector(modules = arrayOf(DetailActivityModule::class))
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector(modules = arrayOf(SOActivityModule::class))
    abstract fun bindSOActivity(): SOActivity
}