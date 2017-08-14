package com.topake.mvvm.ui.detail

import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.core.BaseFragment
import com.topake.mvvm.databinding.FragmentDetail1Binding

class DetailFragment1 : BaseFragment<FragmentDetail1Binding, DetailFragment1ViewModel>() {

    override fun getViewModelClass(): Class<out DetailFragment1ViewModel> {
        return DetailFragment1ViewModel::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_detail1
    }

    override fun registerViewModel() {
        ((activity as BaseActivity<*,*>).vmInteractor as DetailFragment1ViewModel.DetailFragment1ViewModelHolder)
                .register(viewModel)
    }
}