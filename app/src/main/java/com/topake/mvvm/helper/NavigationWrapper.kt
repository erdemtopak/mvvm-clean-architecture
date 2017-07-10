package com.topake.mvvm.helper

import android.os.Bundle
import android.support.v4.app.FragmentActivity

data class NavigationWrapper(val bundle: Bundle, val clazz: Class<out FragmentActivity>)