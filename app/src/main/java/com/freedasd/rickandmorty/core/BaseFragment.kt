package com.freedasd.rickandmorty.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel > : Fragment() {

    abstract fun viewBinding(inflater: LayoutInflater, viewGroup: ViewGroup?) : VB

    abstract fun viewModelClass() : Class<VM>

    private var _binding : VB? = null
    private val binding: VB get() = _binding!!

    private lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[viewModelClass()]
        _binding = viewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}