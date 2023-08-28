package com.ramazantiftik.cryptocomposeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.ramazantiftik.cryptocomposeapp.model.Crypto
import com.ramazantiftik.cryptocomposeapp.repository.CryptoRepository
import com.ramazantiftik.cryptocomposeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel(){

    suspend fun getCrypto(id: String) : Resource<Crypto> {
        return repository.getCrypto(id)
    }

}