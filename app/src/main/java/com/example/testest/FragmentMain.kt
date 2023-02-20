package com.example.testest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.arch.core.util.Function
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.testest.databinding.FragmentMainBinding
import kotlinx.coroutines.launch
import java.util.*



private const val ARG_MONTH_ID = "month_id"

class FragmentMain: Fragment(){
    private lateinit var binding: FragmentMainBinding
    private val nameViewModel: FragmentViewModel by viewModels()

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

        nameViewModel.getNamesLiveData.observe(
            viewLifecycleOwner,
            Observer{ name ->
                name?.let {
                    updateUI()
                }
            }
        )
    }

    private fun updateUI() {
        binding.button.setOnClickListener{

            val edText = binding.editText.text.toString()
            val nameId: UUID = UUID.randomUUID()
            val name = Name(nameId, edText)
            nameViewModel.addName(name = name)
            binding.textView.text = ""
//
//            Transformations.map(nameViewModel.getNamesLiveData, Function { list ->
//                list.forEach {
//                    val text = "ID = ${it.id}, TEXT= ${it.name} \n"
//                    binding.textView.append(text)
//                }
//            })
            nameViewModel.getNamesLiveData.observe(viewLifecycleOwner){list->
                list.forEach { name ->
                    val text = "ID = ${name.id}, TEXT= ${name.name} \n"
                    binding.textView.append(text)
                }
            }
//
//            nameRepository.getNames().observe (viewLifecycleOwner){ list ->
//                list.forEach { name ->
//                    val text = "ID = ${name.id}, TEXT= ${name.name} \n"
//                    binding.textView.append(text)
//                }
//            }
        }
    }

}