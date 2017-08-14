package com.topake.mvvm.ui.detail

import com.topake.mvvm.R
import com.topake.mvvm.core.BaseActivity
import com.topake.mvvm.core.BaseFragment
import com.topake.mvvm.databinding.FragmentDetail2Binding

class DetailFragment2 : BaseFragment<FragmentDetail2Binding, DetailFragment2ViewModel>() {


    override fun getViewModelClass(): Class<out DetailFragment2ViewModel> {
        return DetailFragment2ViewModel::class.java
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_detail2
    }

    override fun registerViewModel() {
        ((activity as BaseActivity<*,*>).vmInteractor as DetailFragment2ViewModel.DetailFragment2ViewModelHolder)
                .register(viewModel)
    }
}