package com.ramazantiftik.cryptocomposeapp.service

import android.database.Observable
import androidx.lifecycle.LiveData
import com.ramazantiftik.cryptocomposeapp.model.Crypto
import com.ramazantiftik.cryptocomposeapp.model.CryptoList
import com.ramazantiftik.cryptocomposeapp.model.CryptoListItem
import com.ramazantiftik.cryptocomposeapp.util.Constans.API_KEY
import com.ramazantiftik.cryptocomposeapp.util.Constans.DETAIL_API_KEY
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET(API_KEY)
    suspend fun getCryptoList(): CryptoList

    @GET(DETAIL_API_KEY)
    suspend fun getCrypto() : Crypto

}