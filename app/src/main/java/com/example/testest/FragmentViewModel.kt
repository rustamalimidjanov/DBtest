package com.example.testest

import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {
    private val _nameRepository = NameRepository.get()
    val nameRepository = _nameRepository.getNames()

    fun getNames() {
        _nameRepository.getNames()
    }
}