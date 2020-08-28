package com.bvpieee

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_event_web_view.*

class EventWebView : AppCompatActivity() {

    var hasConnect = false
    var webSettings: WebSettings? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_web_view)

        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        hasConnect = true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        hasConnect = true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        hasConnect = true
                    }
                }
            }
        } else {
            try {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    hasConnect = true
                }
            } catch (e: Exception) {
                Log.i("update_status", "" + e.message)
            }
        }

        if(hasConnect){
            eventWebView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    if (url != null) {
                        view?.loadUrl(url)
                    }
                    return true
                }
            }
            intent.getStringExtra("url")?.let { eventWebView.loadUrl(it) }
        }
//        if (hasConnect) {
//
//            // show the webview
//            eventWebView.setWebViewClient(object : WebViewClient() {
//                override fun onPageStarted(
//                    view: WebView,
//                    url: String,
//                    favicon: Bitmap
//                ) {
//                    super.onPageStarted(view, url, favicon)
////                    progressBar.setVisibility(View.VISIBLE)
////                    textslow.postDelayed(new Runnable() {
////                        @Override
////                        public void run() {
////                            textslow.setVisibility(View.VISIBLE);
////                        }
////                    },3500);
//                }
//
//                override fun onPageFinished(view: WebView, url: String) {
//                    super.onPageFinished(view, url)
////                    progressBar.setVisibility(View.GONE)
////                    textslow.setVisibility(View.GONE)
//                }
//
//                override fun shouldOverrideUrlLoading(
//                    view: WebView,
//                    request: WebResourceRequest
//                ): Boolean {
//                    val uri = request.url
//                    if (uri.toString().startsWith("intent://")) {
//                        var intent: Intent? = null
//                        try {
//                            intent = Intent.parseUri(uri.toString(), Intent.URI_INTENT_SCHEME)
//                        } catch (e: URISyntaxException) {
//                            e.printStackTrace()
//                        }
//                        if (intent != null) {
//                            val fallbackurl =
//                                intent.getStringExtra("browser_fallback_url")
//                            return if (fallbackurl != null) {
//                                eventWebView.loadUrl(fallbackurl)
//                                true
//                            } else false
//                        }
//                    }
//                    return super.shouldOverrideUrlLoading(view, request)
//                }
//            })
//            eventWebView.loadUrl(intent.getStringExtra("url"))
//            webSettings = eventWebView.getSettings()
////            webSettings.javaScriptEnabled = true
////            webSettings.domStorageEnabled = true
//            eventWebView.canGoBack()
//            eventWebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
//                if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && eventWebView.canGoBack()
//                ) {
//                    eventWebView.goBack()
//                    return@OnKeyListener true
//                }
//                false
//            })
//        } else {
//            // do what ever you need when when no internet connection
////            progressBar.setVisibility(View.GONE)
////            webView.setVisibility(View.GONE)
//        }
    }
}