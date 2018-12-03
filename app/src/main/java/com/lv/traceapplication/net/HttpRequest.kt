package com.lv.traceapplication.net

import android.text.TextUtils

import com.alibaba.fastjson.JSON

import java.io.IOException

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class HttpRequest {

    companion object {
        val instance : HttpRequest by lazy { HttpRequest()}
    }

    operator fun <T> get(url: String?, params: Map<String, Any>, callback: MyCallback<T>){
        val client = OkHttpClient()

        val url = getUrlWithParams(url, params)
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(null, e)
                e.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                try {
                    val result = JSON.parse(response.body()!!.toString()) as T
                    callback.onResponse(result)
                } catch (e: Exception) {

                }

            }
        })
    }

    private fun getUrlWithParams(url: String?, params: Map<String, Any>): String? {
        var url = url
        if (!TextUtils.isEmpty(url)) {
            if (!url!!.endsWith("?")) {
                url += "?"
            }

            val urlBuilder = StringBuilder(url)
            for ((key, value) in params) {
                val param = "$key=$value"
                urlBuilder.append(param).append("&")
            }
            url = urlBuilder.toString()
        }
        return url
    }

}
