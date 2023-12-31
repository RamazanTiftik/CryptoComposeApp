package com.ramazantiftik.cryptocomposeapp.model

import com.google.gson.annotations.SerializedName

data class CryptoListItem(
    @SerializedName("currency")
    val currency: String,

    @SerializedName("price")
    val price: String
)