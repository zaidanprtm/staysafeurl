package com.zaidanpratama.staysafeurl

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("api/phishing?_sort=-date")
    fun getPhising(): Call<PhisingResponse>
}