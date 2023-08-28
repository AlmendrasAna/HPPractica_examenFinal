package com.example.hppractica_examenfinal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hppractica_examenfinal.data.remoto.Wand

@Entity("character_HP_table")
data class CharacterEntity(
    @PrimaryKey val id :String,
    val name: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val ancestry: String,
    val patronus:String,
    val actor: String,
    val alive : Boolean,
    val image : String,
    var wood: String?,
    var core: String?,
    var length: Double? = 0.0
)
