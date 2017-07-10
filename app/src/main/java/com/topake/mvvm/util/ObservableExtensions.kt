package com.topake.mvvm.util

import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

inline fun ObservableBoolean.onPropertyChanged(crossinline listener: (newValue: Boolean) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            listener(get())
        }
    })
}

inline fun <T> ObservableField<T>.onPropertyChanged(crossinline listener: (newValue: T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            listener(get())
        }
    })
}