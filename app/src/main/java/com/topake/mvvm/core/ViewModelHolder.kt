package com.topake.mvvm.core

open class ViewModelHolder {

    val viewModelMap: HashMap<Int, BaseViewModel> = HashMap()

    open fun <T : BaseViewModel> getViewModel(id: Int, viewModelClass: Class<T>): T {
        var instance = viewModelMap[id]
        if (instance == null) {

            try {
                instance = viewModelClass.newInstance()
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