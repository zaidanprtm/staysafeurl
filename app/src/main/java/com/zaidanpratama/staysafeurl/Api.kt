package com.zaidanpratama.staysafeurl

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface Api {
    @GET("api/phishing?_sort=-date")
    fun getPhising(): Call<PhisingResponse>

    @FormUrlEncoded
    @POST("vtapi/v2/url/scan")
    fun pushData(@Field("apikey") apikey: String?, @Field("url") url: String?): Call<ReportResponse>

    @FormUrlEncoded
    @POST("vtapi/v2/url/report")
    fun scanData(@Field("apikey") apikey: String?, @Field("resource") resource: String?): Call<ResultResponse>

}