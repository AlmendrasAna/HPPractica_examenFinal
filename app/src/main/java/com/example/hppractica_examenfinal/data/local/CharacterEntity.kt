package com.example.hppractica_examenfinal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("character_HP_table")
data class CharacterEntity(
    @PrimaryKey val id :String,
    val name: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val length :Int,
    val ancestry: String,
    val core:String,
    val actor: String,
    val alive : Boolean,
    val image : String
)

