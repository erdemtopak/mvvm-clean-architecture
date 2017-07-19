package com.topake.mvvm.helper

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.topake.mvvm.R

class NavigationHelper (val activity: FragmentActivity, val fragmentManager: FragmentManager) {

    fun navigate(navigationWrapper: NavigationWrapper) {

        if (navigationWrapper.navigationState != null) {
            navigate(navigationWrapper.navigationState!!)
            return
        }

        if (navigationWrapper.isActivityNavigation()) {
            navigateActivity(navigationWrapper)
        } else {
            navigateFragment(navigationWrapper)
        }
    }

    fun navigateActivity(navigationWrapper: NavigationWrapper) {
        val intent = Intent(activity, navigationWrapper.navigationClass)
        intent.putExtras(navigationWrapper.bundle)
        activity.startActivity(intent)
    }

    fun navigateFragment(navigationWrapper: NavigationWrapper) {
        val fragment: Fragment? = navigationWrapper.fragment
        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.base_frame_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun navigate(navigationState: NavigationState) {
        when(navigationState) {
            NavigationState.BACK -> activity.onBackPressed()
        }
    }

}