package com.crygen.kizzu

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {

     lateinit var  retrofit : Retrofit

    companion object {
        private fun getClient() : Retrofit {
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        fun getApiService() : ApiInterface {
            return getClient().create(ApiInterface::class.java)
        }
    }

}