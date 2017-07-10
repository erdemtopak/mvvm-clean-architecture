package com.topake.mvvm.ui.main.v1

import com.topake.mvvm.di.BaseActivityModule
import com.topake.mvvm.helper.DummyHelper
import dagger.Module
import dagger.Provides

/**
 * Created by topake on 29/06/2017.
 */

@Module
class MainActivityModuleV2 : BaseActivityModule() {

    @Provides
    fun provideDummyHelper(): DummyHelper = DummyHelper()

}