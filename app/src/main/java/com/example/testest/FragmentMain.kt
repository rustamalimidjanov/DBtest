package com.example.testest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testest.databinding.FragmentMainBinding
import java.util.*

private const val ARG_MONTH_ID = "month_id"

class FragmentMain: Fragment(){
    private lateinit var binding: FragmentMainBinding
    private lateinit var name: Name
    private val nameRepository = NameRepository.get()


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
        binding.button.setOnClickListener{
            val edText = binding.editText.text.toString()
            val nameId: UUID = UUID.randomUUID()
            val name = Name(nameId, edText)
            nameRepository.addName(name = name)
            binding.textView.text = name.name
        }
    }

}