package com.lv.traceapplication.net

import okhttp3.Callback
import okhttp3.Request
import java.io.IOException

abstract class MyCallback<T> : Callback {

    abstract fun onFailure(request: Request, e: IOException)

    @Throws(IOException::class)
    abstract fun onResponse(response: T)
}