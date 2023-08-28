package com.example.hppractica_examenfinal.data.remoto

import com.google.gson.annotations.SerializedName

data class CharacterData(
    val id: String,
    val name: String,
    val gender: String,
    val house: String,
    val wand: Wand,
    val dateOfBirth: String,
    val ancestry: String,
    val patronus: String,
    val actor: String,
    val alive: Boolean,
    val image: String
)


data class Wand(

    var wood: String,
    var core: String,
    var length: Double?

)
