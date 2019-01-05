package com.crygen.kizzu.model

import com.google.gson.annotations.SerializedName

class UserData{
    @SerializedName("first_name")
    var firstName = ""

    @SerializedName("last_name")
    var lastName = ""

    @SerializedName("email")
    var email = ""

    @SerializedName("phone")
    var phone = ""

    @SerializedName("birthday")
    var birthday = ""

}
