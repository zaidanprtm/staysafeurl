package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class QuickHeal(
    @SerializedName("detected")
    val detected: Boolean,
    @SerializedName("result")
    val result: String
)