package com.topake.mvvm.helper

import android.support.annotation.StringRes
import com.topake.mvvm.R
import com.topake.mvvm.core.SampleApp

/**
 * Created by topake on 28/06/2017.
 */

class ResourceHelper private constructor() {

    companion object {
        fun getString(@StringRes resId: Int): String {
            return SampleApp.getAppContext().getString(R.string.dummy_text)
        }
    }

}