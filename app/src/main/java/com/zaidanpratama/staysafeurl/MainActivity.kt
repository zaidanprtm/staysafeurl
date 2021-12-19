package com.zaidanpratama.staysafeurl

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
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
                        number.toString() + "."
                        val phising = ListItem(number.toString(), responseApi[i].url, responseApi[i].ip)
                        newArrayList.add(phising)
                    }
                    var adapter = ItemAdapter(newArrayList)
                    recyclerView.adapter = adapter

                } else {
                    println("Error")
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
        val reportData = retrofitBuilder.pushData("", url.text.toString())

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
                    val intent = Intent(this@MainActivity, ErrorActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                println(t.message)
                val intent = Intent(this@MainActivity, ErrorActivity::class.java)
                startActivity(intent)
            }
        })
    }

    fun scanURL(view: View) {
        val base_url = "https://www.virustotal.com/"
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(base_url).build().create(Api::class.java)
        val resultData = retrofitBuilder.scanData("", url.text.toString())

        resultData.enqueue(object: Callback<ResultResponse> {

            override fun onResponse(call: Call<ResultResponse>, response: Response<ResultResponse>) {
                if (response.isSuccessful) {
                    var responseApi = response.body()
                    print(responseApi)
                    var scanResult = responseApi?.scans
                    var cmc = scanResult?.cMCThreatIntelligence?.result
                    var bitdefender = scanResult?.bitDefender?.result
                    var armis = scanResult?.armis?.result
                    var phishlabs = scanResult?.phishLabs?.result
                    var viriback = scanResult?.viriBack?.result
                    var cyren = scanResult?.cyren?.result
                    var quttera = scanResult?.quttera?.result
                    var openphish = scanResult?.openPhish?.result
                    var blocklist = scanResult?.blockList?.result
                    var alienvault = scanResult?.alienVault?.result
                    var cyan = scanResult?.cyan?.result
                    var phishtank = scanResult?.phishtank?.result
                    var phisingdatabase = scanResult?.phishingDatabase?.result
                    var googlesafe = scanResult?.googleSafebrowsing?.result
                    var safetoopen = scanResult?.safeToOpen?.result
                    var malwaredomain = scanResult?.malwareDomainList?.result
                    var malwarepatrol = scanResult?.malwarePatrol?.result
                    var fraudscore = scanResult?.fraudScore?.result
                    var tencent = scanResult?.tencent?.result
                    var vxvault = scanResult?.vXVault?.result
                    var securebrain = scanResult?.secureBrain?.result
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("url", responseApi?.url.toString())
                    intent.putExtra("cmc", cmc)
                    intent.putExtra("bitdefender", bitdefender)
                    intent.putExtra("armis", armis)
                    intent.putExtra("phishlabs", phishlabs)
                    intent.putExtra("viriback", viriback)
                    intent.putExtra("cyren", cyren)
                    intent.putExtra("quttera", quttera)
                    intent.putExtra("openphish", openphish)
                    intent.putExtra("blocklist", blocklist)
                    intent.putExtra("alienvault", alienvault)
                    intent.putExtra("cyan", cyan)
                    intent.putExtra("phishtank", phishtank)
                    intent.putExtra("phisingdatabase", phisingdatabase)
                    intent.putExtra("googlesafe", googlesafe)
                    intent.putExtra("safetoopen", safetoopen)
                    intent.putExtra("malwaredomain", malwaredomain)
                    intent.putExtra("malwarepatrol", malwarepatrol)
                    intent.putExtra("fraudscore", fraudscore)
                    intent.putExtra("tencent", tencent)
                    intent.putExtra("vxvault", vxvault)
                    intent.putExtra("securebrain", securebrain)
                    startActivity(intent)
                } else {
                    println("error")
                    val intent = Intent(this@MainActivity, ErrorActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                println(t.message)
                val intent = Intent(this@MainActivity, ErrorActivity::class.java)
                startActivity(intent)
            }
        })
    }
}