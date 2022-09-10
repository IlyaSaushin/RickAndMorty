package com.freedasd.rickandmorty.core

interface BaseMapper<D, R> {

    fun map(data: D) : R
}