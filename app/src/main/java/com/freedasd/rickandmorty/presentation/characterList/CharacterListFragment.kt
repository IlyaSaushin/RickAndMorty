package com.freedasd.rickandmorty.presentation.characterList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freedasd.rickandmorty.core.BaseFragment
import com.freedasd.rickandmorty.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

interface MoreCharactersLoader {

    suspend fun load(page: Int)
}

@AndroidEntryPoint
class CharacterListFragment @Inject constructor(): BaseFragment<FragmentCharacterListBinding>() {

    private val viewModel : CharacterListViewModel by viewModels()
    private var isLoading = false
    private var loadingPage = START_CHARACTERS_LIST_PAGE

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharacterListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler()

        viewModel.fetchCharacterList(loadingPage)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun recycler() {

        val adapter = CharacterListAdapter()
        binding.recyclerView.adapter = adapter

        val manager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.layoutManager = manager

        val scrollListener = object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemsCount = manager.childCount
                val totalItemsCount = manager.itemCount
                val firstVisibleItem = manager.findFirstVisibleItemPosition()

                if (!Loader().loaded) {
                    if ((visibleItemsCount+firstVisibleItem) >= totalItemsCount) {

                        loadingPage += 1
                        loadMoreCharacters(loadingPage)
//                        isLoading = true
//                        loadMoreCharacters(loadingPage)
                    }
                }
            }
        }
        binding.recyclerView.addOnScrollListener(scrollListener)
        viewModel.observeCharacterList(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            Loader().loaded = false
        }
    }

    private fun loadMoreCharacters(page: Int) {
        viewModel.fetchCharacterList(page)
    }

    private inner class Loader : MoreCharactersLoader {

        var loaded = false

        override suspend fun load(page: Int) {
            viewModel.fetchCharacterList(page)
        }
    }

    companion object {

        private const val START_CHARACTERS_LIST_PAGE = 1

        fun newInstance() = CharacterListFragment()
    }
}