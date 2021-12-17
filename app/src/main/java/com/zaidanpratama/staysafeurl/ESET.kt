package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class ESET(
    @SerializedName("detected")
    val detected: Boolean,
    @SerializedName("result")
    val result: String
)