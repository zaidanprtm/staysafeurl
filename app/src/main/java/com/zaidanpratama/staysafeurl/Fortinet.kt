package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class Fortinet(
    @SerializedName("detected")
    val detected: Boolean,
    @SerializedName("result")
    val result: String
)