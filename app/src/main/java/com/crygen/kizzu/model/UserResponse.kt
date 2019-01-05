package com.crygen.kizzu.model

import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("success")
    var success : Boolean = false

    @SerializedName("userdata")
    var userData : UserData? = null

}