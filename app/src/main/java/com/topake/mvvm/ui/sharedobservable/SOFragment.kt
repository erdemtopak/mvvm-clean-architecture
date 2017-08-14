package com.topake.mvvm.ui.sharedobservable

import com.topake.mvvm.R
import com.topake.mvvm.core.BaseFragment
import com.topake.mvvm.databinding.FragmentSoBinding

class SOFragment : BaseFragment<FragmentSoBinding, SOFragmentVM>() {

    override fun getViewModelClass(): Class<out SOFragmentVM> {
        return SOFragmentVM::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_so
    }

}