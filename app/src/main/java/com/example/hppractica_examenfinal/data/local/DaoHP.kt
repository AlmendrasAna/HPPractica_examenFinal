package com.example.hppractica_examenfinal.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoHP {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertsListCharacterHP(listEntitys: List<CharacterEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertsOneCharacterHP(entity: CharacterEntity)

    @Query("select * from character_HP_table order by id ASC ")
    fun showListCharacterHP(): LiveData<List<CharacterEntity>>

}