package com.lv.traceapplication.net

import com.alibaba.fastjson.annotation.JSONField

open class BaseModel {
    @JSONField(name = "error")
    val error: Int = -1
    @JSONField(name = "errmsg")
    val errmsg: String =""
}