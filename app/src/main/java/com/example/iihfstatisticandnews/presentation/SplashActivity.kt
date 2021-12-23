package com.example.iihfstatisticandnews.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.data.network.models.RequestDto
import com.example.iihfstatisticandnews.data.network.models.ResponseDto
import com.example.iihfstatisticandnews.data.network.retrofit.ApiFactory
import com.example.iihfstatisticandnews.databinding.ActivitySplashBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private val apiService = ApiFactory.apiService

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadJsonPicture()

        val webView = binding.webView

        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
        Log.d("LANGUAGE_CURR", lang.isO3Language)
        val requestDto = RequestDto(lang.isO3Language)
        val responseDto = apiService.sendLocale(requestDto)
        val request = responseDto.enqueue(object : Callback<ResponseDto>{
            @SuppressLint("SetJavaScriptEnabled")
            override fun onResponse(p0: Call<ResponseDto>, p1: Response<ResponseDto>) {
                Log.d("P1BODY","Ответ - ${p1.body().toString()}")
                if(p1.body()?.response == "no"){
                    Toast.makeText(this@SplashActivity,"Ответ от сервера -> ${p1.body().toString()}",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                }else{
                    hideSetUp()
                    supportActionBar?.hide()
                    webView.visibility = View.VISIBLE
                    webView.loadUrl(p1.body()?.response?:"google.com")
                    webView.settings.javaScriptEnabled = true
                    webView.webViewClient = WebViewClient()
                }
            }

            override fun onFailure(p0: Call<ResponseDto>, p1: Throwable) {
                startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                Log.d("ONFAILURE",p1.message.toString())
            }

        })

    }

    private fun hideSetUp(){
        binding.progressBar.visibility = View.GONE
        binding.textViewSetup.visibility = View.GONE
    }

    private fun loadJsonPicture() {
        try {
            Glide.with(this).load("http://95.217.132.144/iihf/background_image.jpg")
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                        binding.splashLayout.background = dr
                    }

                    override fun onLoadCleared(p0: Drawable?) {

                    }
                })
        } catch (e: Exception) {
        }
    }
}