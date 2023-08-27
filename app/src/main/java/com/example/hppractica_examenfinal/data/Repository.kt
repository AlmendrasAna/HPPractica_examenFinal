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
            Log.e("lol", "antes response")
            val response = apiHP.getProductsData()
            if (response.isSuccessful) {
                val bodyResponse = response.body()
               // Log.e("lol", "antesk response")
                bodyResponse?.let { listData ->
                   // Log.e("lol", "Error body" + listData.size.toString())
                    val listDataEntity = listData.map { data ->
                  //      Log.e("lol", "Error body $data")
                        data.toCharacterEntity()



                    }
                    daoHP.insertsListCharacterHP(listDataEntity)
                    Log.e("lol", "Error bod,,,y")
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
    this.dateOfBirth.isNull(),
    this.ancestry,
    this.patronus,
    this.actor,
    this.alive,
    this.image
)

fun String?.isNull(): String {
    val txt = this
    if (txt.isNullOrEmpty()) {return "No Disponible"}
    return txt
}