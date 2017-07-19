package com.topake.mvvm.core

interface InteractorOwner<out T : BaseInteractor> {

    fun getInteractor(): T
}