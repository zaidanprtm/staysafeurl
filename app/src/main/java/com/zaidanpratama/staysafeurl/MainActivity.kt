package com.zaidanpratama.staysafeurl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
    private lateinit var url: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerviewPhising)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<ListItem>()
        getPhising()
        url = findViewById(R.id.textURL)
//        val reportButton : Button = findViewById(R.id.report_button)
//        if (url.text.toString().isEmpty()) {
//            Toast.makeText(this@MainActivity, "URL is empty", Toast.LENGTH_SHORT).show()
//        } else {
//            println(url)
//            reportButton.setOnClickListener {
//                reportURL(url.toString())
//            }
//        }
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

    fun reportURL(view: View) {
        val base_url = "https://www.virustotal.com/"
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(base_url).build().create(Api::class.java)
        val reportData = retrofitBuilder.pushData("a0d7d09bab51a2fccd1e796bd176cbd576d6064f997eb29baca028ed75936523", url.text.toString())

        reportData.enqueue(object: Callback<ReportResponse> {

            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                if (response.isSuccessful) {
                    var responseApi = response.body()
//                    println(responseApi)
                    val intent = Intent(this@MainActivity, ReportActivity::class.java)
                    intent.putExtra("permalink", responseApi?.permalink.toString())
                    startActivity(intent)
                } else {
                    println("error")
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                println(t.message)
            }
        })
    }
}