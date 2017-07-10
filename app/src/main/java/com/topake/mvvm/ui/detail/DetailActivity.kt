package com.topake.mvvm.ui.detail

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.topake.mvvm.R
import com.topake.mvvm.helper.NavigationWrapper

/**
 * Created by topake on 29/06/2017.
 */

class DetailActivity : FragmentActivity() {

    companion object {
        val KEY_DUMMY_TEXT = "KEY_DUMMY_TEXT"

        fun createNavigationWrapper(dummyText: String): NavigationWrapper {
            val bundle = Bundle()
            bundle.putString(KEY_DUMMY_TEXT, dummyText)
            return NavigationWrapper(bundle, DetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Toast.makeText(this, intent.extras.getString(KEY_DUMMY_TEXT), Toast.LENGTH_SHORT).show()
    }

}