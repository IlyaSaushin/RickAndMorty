package com.freedasd.rickandmorty.presentation.characterList

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freedasd.rickandmorty.core.BaseFragment
import com.freedasd.rickandmorty.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify
import javax.inject.Inject

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
                val firstVisibleItems = manager.findFirstVisibleItemPosition()

                if (!isLoading) {
                    if ( (visibleItemsCount+firstVisibleItems) >= totalItemsCount) {
                        Toast.makeText(requireContext(), "List is over", Toast.LENGTH_SHORT).show()
                        isLoading = true

//                        loadMoreCharacters()
                        if (loadingPage <= 42){
                            loadingPage += 1
                            viewModel.fetchCharacterList(loadingPage)
                            isLoading = false

                        }

//                        if (loadingListener != null) {
//                            loadingListener.loadMoreItems()
//                        }
                    }
                }
            }
        }
        binding.recyclerView.addOnScrollListener(scrollListener)
        viewModel.observeCharacterList(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun loadMoreCharacters() {
        // todo
    }

//    private inner class ScrollListener() : RecyclerView.OnScrollListener() {
//        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//            super.onScrolled(recyclerView, dx, dy)
//            val manager = GridLayoutManager(requireContext(), 2)
//            val visibleItemCount = manager.childCount ;//смотрим сколько элементов на экране
//            val totalItemCount = manager.itemCount ;//сколько всего элементов
//            val firstVisibleItems = manager.findFirstVisibleItemPosition() //какая позиция первого элемента
////            Toast.makeText(requireContext(), "$totalItemCount", Toast.LENGTH_SHORT).show()
//
//            if (!isLoading) {//проверяем, грузим мы что-то или нет, эта переменная должна быть вне класса  OnScrollListener
//                if ( (visibleItemCount+firstVisibleItems) >= totalItemCount) {
//                    Toast.makeText(requireContext(), "List is over", Toast.LENGTH_SHORT).show()
////                    isLoading = true;//ставим флаг что мы попросили еще элемены
////                    if (loadingListener != null) {
////                        loadingListener.loadMoreItems();//тут я использовал калбэк который просто говорит наружу что нужно еще элементов и с какой позиции начинать загрузку
////                    }
//                }
//            }
//        }
//    }

    companion object {

        private const val START_CHARACTERS_LIST_PAGE = 1

        fun newInstance() = CharacterListFragment()
    }
}