package com.zaidanpratama.staysafeurl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhising()
    }

    private fun getPhising() {
        val base_url = "https://phishstats.info:2096/"
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(base_url).build().create(Api::class.java)
        val phisingData = retrofitBuilder.getPhising()

        phisingData.enqueue(object: Callback<PhisingResponse> {

            override fun onResponse(call: Call<PhisingResponse>, response: Response<PhisingResponse>) {
                if (response.isSuccessful) {
                    var responseApi = response.body()
                    println(responseApi)

                } else {
                }
            }

            override fun onFailure(call: Call<PhisingResponse>, t: Throwable) {
                println(t.message)
            }
        })
    }
}