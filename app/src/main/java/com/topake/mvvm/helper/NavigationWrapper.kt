package com.topake.mvvm.helper

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class NavigationWrapper {

    var navigationState : NavigationState? = null
    var bundle : Bundle? = null
    var navigationClass : Class<out FragmentActivity>? = null
    var fragment : Fragment? = null

    constructor(bundle: Bundle?, navigationClass: Class<out FragmentActivity>) {
        this.bundle = bundle
        this.navigationClass = navigationClass
    }

    constructor(fragment: Fragment) {
        this.fragment = fragment
    }

    constructor(navigationState: NavigationState) {
        this.navigationState = navigationState
    }

    fun isActivityNavigation() = fragment == null
}
