package com.zaidanpratama.staysafeurl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val bundle : Bundle? = intent.extras
        val link = bundle?.getString("permalink")
        val webView: WebView = findViewById(R.id.webview)
        webView.loadUrl(link.toString())
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.domStorageEnabled = true
    }
}