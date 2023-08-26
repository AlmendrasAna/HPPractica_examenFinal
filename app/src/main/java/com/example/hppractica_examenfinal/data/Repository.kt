package com.example.hppractica_examenfinal.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.hppractica_examenfinal.data.local.CharacterEntity
import com.example.hppractica_examenfinal.data.local.DaoHP
import com.example.hppractica_examenfinal.data.remoto.ApiHP
import com.example.hppractica_examenfinal.data.remoto.CharacterData

class Repository(private val apiHP: ApiHP, private val daoHP: DaoHP) {
    fun showCharacterEntityList(): LiveData<List<CharacterEntity>> = daoHP.showListCharacterHP()

    suspend fun loadAllCharacter() {
        try {

            val response = apiHP.getProductsData()
            if (response.isSuccessful) {
                val bodyResponse = response.body()

                bodyResponse?.let { listData ->
                    val listCharacterEntity = listData.map {data ->
                        data.toCharacterEntity()
                    }
                    daoHP.insertsListCharacterHP(listCharacterEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "Error")
        }
    }


}

fun CharacterData.toCharacterEntity(): CharacterEntity = CharacterEntity(
    this.id,
    this.name,
    this.gender,
    this.house,
    this.dateOfBirth,
    this.length,
    this.ancestry,
    this.core,
    this.actor,
    this.alive,
    this.image
)
