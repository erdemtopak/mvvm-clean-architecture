package com.topake.mvvm.ui.sharedobservable

import com.topake.mvvm.core.BaseViewModel
import com.topake.mvvm.core.ViewModelHolder

class SOVMHolder(val soWrapper: SOWrapper) : ViewModelHolder() {

    override fun <T : BaseViewModel> getViewModel(id: Int, viewModelClass: Class<T>): T {
        var instance = viewModelMap[id]
        if (instance == null) {

            try {
                if (SOHolder::class.java.isAssignableFrom(viewModelClass)) {
                    instance = viewModelClass.getConstructor(soWrapper.javaClass).newInstance(soWrapper)
                } else {
                    instance = viewModelClass.newInstance()
                }
            } catch (e: InstantiationException) {
                throw RuntimeException("Cannot create an instance of " + viewModelClass, e)
            } catch (e: IllegalAccessException) {
                throw RuntimeException("Cannot create an instance of " + viewModelClass, e)
            }

            viewModelMap.put(id, instance)
        }
        return instance as T
    }
}