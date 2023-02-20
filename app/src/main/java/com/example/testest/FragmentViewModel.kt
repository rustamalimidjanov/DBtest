package com.example.testest

import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {
    private val nameRepository = NameRepository.get()
    val getNamesLiveData = nameRepository.getNames()


    fun getNames() {
        nameRepository.getNames()
    }

    fun addName(name: Name){
        nameRepository.addName(name = name)
    }
}