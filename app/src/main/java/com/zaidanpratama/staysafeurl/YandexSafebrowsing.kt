package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class YandexSafebrowsing(
    @SerializedName("detail")
    val detail: String,
    @SerializedName("detected")
    val detected: Boolean,
    @SerializedName("result")
    val result: String
)