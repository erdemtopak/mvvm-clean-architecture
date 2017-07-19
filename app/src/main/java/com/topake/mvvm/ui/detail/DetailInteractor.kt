package com.topake.mvvm.ui.detail

import com.topake.mvvm.core.BaseInteractor
import com.topake.mvvm.util.onPropertyChanged

class DetailInteractor(val vmActivity: DetailActivityViewModel) : BaseInteractor(),
        DetailFragment1ViewModel.DetailFragment1ViewModelHolder,
        DetailFragment2ViewModel.DetailFragment2ViewModelHolder {

    lateinit var vm1: DetailFragment1ViewModel
    lateinit var vm2: DetailFragment2ViewModel

    override fun register(vm: DetailFragment1ViewModel) {
        vm1 = vm
    }

    override fun register(vm: DetailFragment2ViewModel) {
        vm2 = vm
        vm2.approvedState.onPropertyChanged {
            vm1.checkStatus.set(true)
        }
    }
}