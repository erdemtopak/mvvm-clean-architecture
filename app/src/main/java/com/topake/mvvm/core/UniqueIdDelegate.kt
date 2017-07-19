package com.topake.mvvm.core

import android.os.Bundle

class UniqueIdDelegate {

    val KEY_UNIQUE_ID = "UNIQUE_ID"
    val INVALID_ID = -1
    var uniqueId: Int = INVALID_ID

    fun generate(instance: Any, savedState: Bundle?) {
        if (uniqueId == INVALID_ID) {
            uniqueId = hashCode()
            if (savedState != null) {
                savedState.getInt(KEY_UNIQUE_ID, instance.hashCode())
            } else {
                uniqueId = instance.hashCode()
            }
        }
    }

    fun saveState(state: Bundle?) {
        state?.putInt(KEY_UNIQUE_ID, uniqueId)
    }
}