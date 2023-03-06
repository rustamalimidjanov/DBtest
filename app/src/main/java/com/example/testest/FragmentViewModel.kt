package com.example.testest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class FragmentViewModel: ViewModel() {
    private val nameRepository = NameRepository.get()
    val getNamesLiveData = nameRepository.getNames()

    private val _setEditNameLiveData = MutableLiveData<String>()
    val setEditNameLiveData: LiveData<String> = _setEditNameLiveData

    fun saveEditState(state: String) {
        _setEditNameLiveData.value = state
    }
    fun getNames() {
        nameRepository.getNames()
    }

    fun addName(name: Name){
        nameRepository.addName(name = name)
    }
}