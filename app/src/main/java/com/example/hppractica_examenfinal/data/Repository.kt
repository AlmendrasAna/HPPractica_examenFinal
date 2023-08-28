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
    this.name.isNull(),
    this.gender.isNull(),
    this.house.isNull(),
    this.dateOfBirth.isNull(),
    this.ancestry.isNull(),

    this.patronus.isNull(),
    this.actor.isNull(),
    this.alive,
    this.image,
    this.wand.wood.isNull(),
    this.wand.core.isNull(),
    this.wand?.length

)




fun Double?.isDoubleNull():Double
{
    val num = this


    if ( num.toString().isNullOrEmpty()) {

        return 0.1
    }
    return num!!
}
fun String?.isNull(): String {
    val txt = this
    if (txt.isNullOrEmpty()) {
        return "No Disponible"
    }
    return txt
}