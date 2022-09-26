package com.freedasd.rickandmorty.presentation.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.freedasd.rickandmorty.core.BaseFragment
import com.freedasd.rickandmorty.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CharacterListFragment @Inject constructor(): BaseFragment<FragmentCharacterListBinding>() {

    private val viewModel : CharacterListViewModel by viewModels()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharacterListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharacterListAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    companion object {

        fun newInstance() = CharacterListFragment()
    }
}