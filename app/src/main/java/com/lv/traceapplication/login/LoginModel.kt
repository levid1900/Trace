package com.lv.traceapplication.login

import com.alibaba.fastjson.annotation.JSONField
import com.lv.traceapplication.net.BaseModel

class LoginModel : BaseModel() {
    @JSONField(name = "role")
    val role: Int = 0
    @JSONField(name = "uid")
    val uid: String = ""
}