package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class BitDefender(
    @SerializedName("detected")
    val detected: Boolean,
    @SerializedName("result")
    val result: String
)