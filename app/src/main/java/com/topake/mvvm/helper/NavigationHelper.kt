package com.topake.mvvm.helper

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentManager

class NavigationHelper constructor(val context: Context, val fragmentManager: FragmentManager) {

    fun navigate(navigationWrapper: NavigationWrapper) {
        val intent = Intent(context, navigationWrapper.clazz)
        intent.putExtras(navigationWrapper.bundle)
        context.startActivity(intent)
    }

}