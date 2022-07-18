package com.example.myfourpageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class WebActivity : AppCompatActivity() {var buttonGoToWeb: Button?= null
    var webViewSite: WebView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        webViewSite = findViewById(R.id.mWebSite)
        var webSettings = webViewSite!!.settings
        webSettings.javaScriptEnabled = true
        webViewSite!!.loadUrl("https://www.emobilis.ac.ke/")
    }
}