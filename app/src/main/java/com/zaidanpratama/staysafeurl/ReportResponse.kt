package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("resource")
    val resource: String,
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("scan_date")
    val scanDate: String,
    @SerializedName("scan_id")
    val scanId: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("verbose_msg")
    val verboseMsg: String
)