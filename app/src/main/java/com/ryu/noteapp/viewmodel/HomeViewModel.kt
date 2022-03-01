package com.ryu.noteapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val memo = MutableLiveData<String>()

    val enabled = MediatorLiveData<Boolean>()

    init {
        enabled.value = false

        enabled.addSource(memo) {
            val count = memo.value?.length!! >= 6
            enabled.postValue(count)
        }
    }

    fun registerMemo() {}
}
