package com.ramazantiftik.cryptocomposeapp.repository

import com.ramazantiftik.cryptocomposeapp.model.Crypto
import com.ramazantiftik.cryptocomposeapp.model.CryptoList
import com.ramazantiftik.cryptocomposeapp.model.CryptoListItem
import com.ramazantiftik.cryptocomposeapp.service.RetrofitAPI
import com.ramazantiftik.cryptocomposeapp.util.Resource
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val api: RetrofitAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response= try {
            api.getCryptoList()
        } catch (e: Exception) {
            return Resource.Error("Error")
        }

        return Resource.Success(response)
    }

    suspend fun getCrypto(id : String) : Resource<Crypto> {
        val response=try {
            api.getCrypto()
        } catch (e: Exception){
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

}