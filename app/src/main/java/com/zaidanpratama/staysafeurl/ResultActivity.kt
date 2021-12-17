package com.zaidanpratama.staysafeurl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResultActivity : AppCompatActivity() {
    private lateinit var resultArrayList: ArrayList<ListItem>
    private lateinit var recyclerView : RecyclerView
    lateinit var resultTitle : Array<String>
    lateinit var resultBody : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val bundle : Bundle? = intent.extras
        val link = bundle?.getString("url").toString()
        val cmc = bundle?.getString("cmc").toString()
        val bitdefender = bundle?.getString("bitdefender").toString()
        val armis = bundle?.getString("armis").toString()
        val phishlabs = bundle?.getString("phishlabs").toString()
        val viriback = bundle?.getString("viriback").toString()
        val cyren = bundle?.getString("cyren").toString()
        val quttera = bundle?.getString("quttera").toString()
        val openphish = bundle?.getString("openphish").toString()
        val blocklist = bundle?.getString("blocklist").toString()
        val alientvault = bundle?.getString("alientvault").toString()
        val cyan = bundle?.getString("cyan").toString()
        val phishtank = bundle?.getString("phishtank").toString()
        val phisingdatabase = bundle?.getString("phisingdatabase").toString()
        val googlesafe = bundle?.getString("googlesafe").toString()
        val safetoopen = bundle?.getString("safetoopen").toString()
        val malwaredomain = bundle?.getString("malwaredomain").toString()
        val malwarepatrol = bundle?.getString("malwarepatrol").toString()
        val fraudscore = bundle?.getString("fraudscore").toString()
        val tencent = bundle?.getString("tencent").toString()
        val vxvault = bundle?.getString("vxvault").toString()
        val securebrain = bundle?.getString("securebrain").toString()
        findViewById<TextView>(R.id.urlReported).text = link
        resultTitle = arrayOf(
            "CMC Threat Intelligence",
            "Bitdefender",
            "Armis",
            "PhishLabs",
            "Viriback",
            "Cyren",
            "Quttera",
            "OpenPhish",
            "Blocklist",
            "AlienVault",
            "Cyan",
            "PhishTank",
            "PhisingDatabase",
            "Google Safe Browsing",
            "SafeToOpen",
            "Malware Domain",
            "Malware Patrol",
            "FraudScore",
            "Tencent",
            "VXVault",
            "SecureBrain"
        )
        resultBody = arrayOf(
            cmc,
            bitdefender,
            armis,
            phishlabs,
            viriback,
            cyren,
            quttera,
            openphish,
            blocklist,
            alientvault,
            cyan,
            phishtank,
            phisingdatabase,
            googlesafe,
            safetoopen,
            malwaredomain,
            malwarepatrol,
            fraudscore,
            tencent,
            vxvault,
            securebrain
        )
        recyclerView = findViewById<RecyclerView>(R.id.recyclerviewReport)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        resultArrayList = arrayListOf<ListItem>()
        for (i in resultTitle.indices){
            val number = i + 1
            number.toString() + "."
            val result = ListItem(number.toString(), resultTitle[i], resultBody[i])
            resultArrayList.add(result)
        }
        var adapter = ItemAdapter(resultArrayList)
        recyclerView.adapter = adapter
    }
}