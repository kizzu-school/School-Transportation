package com.crygen.kizzu

import com.crygen.kizzu.fragment.LoginFragment
import com.crygen.kizzu.model.ResultResponse
import com.crygen.kizzu.model.UserData
import com.crygen.kizzu.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("/login")
    fun login(@Body body : LoginFragment.Login) : Call<ResultResponse>

    @POST("/signup")
    fun signUp(@Body body : UserData) : Call<ResultResponse>

    @GET("/profile")
    fun getProfile(@Query("user_id") id : String) : Call<UserResponse>

    @POST("/update_profile")
    fun update(@Body extractModel: UserData) : Call<ResultResponse>
}