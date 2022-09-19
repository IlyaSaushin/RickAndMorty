package com.freedasd.rickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.freedasd.rickandmorty.R
import com.freedasd.rickandmorty.presentation.characterList.CharacterListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initStartFragment()
    }

    private fun initStartFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, CharacterListFragment.newInstance())
            .commit()
    }
}