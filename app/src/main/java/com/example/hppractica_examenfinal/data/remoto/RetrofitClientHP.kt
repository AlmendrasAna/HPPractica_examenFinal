package com.example.hppractica_examenfinal.data.remoto


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientHP {

    companion object {
        private const val URL_BASE = "https://hp-api.onrender.com/api/characters/"

        fun getRetrofitHP(): ApiHP {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(ApiHP::class.java)
        }
    }
}