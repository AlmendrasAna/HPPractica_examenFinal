package com.example.hppractica_examenfinal.data.remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiHP {


        @GET("characters/")
        suspend fun getProductsData(): Response<List<CharacterData>>

        @GET("characters/house/{house}")
        suspend fun getListCharacterHouse(@Path("house")house:String):Response<CharacterData>

}