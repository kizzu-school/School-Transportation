package com.crygen.kizzu

import com.crygen.kizzu.fragment.LoginFragment
import com.crygen.kizzu.model.ResultResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/login")
    fun login(@Body body : LoginFragment.Login) : Call<ResultResponse>
}