package com.example.hppractica_examenfinal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.hppractica_examenfinal.R
import com.example.hppractica_examenfinal.databinding.FragmentCharacterListBinding
import com.example.hppractica_examenfinal.view.adapter.Adapter


class CharacterListFragment : Fragment() {


    lateinit var binding: FragmentCharacterListBinding
    private val viewModelHP: ViewModelHP by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        viewModelHP.getAllProducts()
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = Adapter()
        binding.recyclerCharacter.adapter = adapter

        viewModelHP.charactersLiveData().observe(viewLifecycleOwner){listData->

            adapter.setData(listData)

        }

    }

}