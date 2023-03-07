package com.example.testest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.testest.databinding.FragmentMainBinding
import java.util.*

class FragmentMain: Fragment(){
    private lateinit var binding: FragmentMainBinding
    private val nameViewModel: FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearText()

        nameViewModel.getNamesLiveData.observe(
            viewLifecycleOwner,
            Observer{
                it?.let { names ->
                    names.forEach { name ->
                        val text = "ID = ${name.id}, TEXT= ${name.name} \n"
                        binding.textView.append(text)
                        binding.editText.setText(name.name)
                    }
                    updateUI()
                }
            }
        )
    }

    private fun updateUI() {
        binding.button.setOnClickListener{
            val edText = binding.editText.text.toString()
            val nameId: UUID = UUID.randomUUID()
            val name = Name(id = nameId, name = edText)
            nameViewModel.addName(name = name)

        }
    }
    private fun clearText() {
        binding.textView.text = ""
    }
}