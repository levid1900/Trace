package com.lv.traceapplication.utils

import android.content.Context
import com.lv.traceapplication.BaseApplication

class Preferences {
    companion object {
        val instance by lazy { Preferences() }
    }

    private val sharedPref = BaseApplication.context.getSharedPreferences(
            "TRACE_PREFERENCE", Context.MODE_PRIVATE)

    private fun setUid(uid: String) {
        with(sharedPref.edit()) {
            putString("uid", uid)
            commit()
        }
    }

    private fun getUid() = sharedPref.getString("uid", "")
}