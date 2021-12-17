package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("filescan_id")
    val filescanId: Any,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("positives")
    val positives: Int,
    @SerializedName("resource")
    val resource: String,
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("scan_date")
    val scanDate: String,
    @SerializedName("scan_id")
    val scanId: String,
    @SerializedName("scans")
    val scans: Scans,
    @SerializedName("total")
    val total: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("verbose_msg")
    val verboseMsg: String
)