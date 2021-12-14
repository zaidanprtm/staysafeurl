package com.zaidanpratama.staysafeurl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var newArrayList: ArrayList<ListItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerviewPhising)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<ListItem>()
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
//                    println(responseApi)
                    for (i in responseApi!!.indices){
                        val number = i + 1
                        val phising = ListItem(number.toString(), responseApi[i].url, responseApi[i].ip)
                        newArrayList.add(phising)
                    }
                    var adapter = ItemAdapter(newArrayList)
                    recyclerView.adapter = adapter

                } else {
                }
            }

            override fun onFailure(call: Call<PhisingResponse>, t: Throwable) {
                println(t.message)
            }
        })
    }
}