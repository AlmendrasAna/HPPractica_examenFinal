package com.example.hppractica_examenfinal.data.remoto/*
id	"9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8"
name	"Harry Potter"
alternate_names
0	"The Boy Who Lived"
1	"The Chosen One"
species	"human"
gender	"male"
house	"Gryffindor"
dateOfBirth	"31-07-1980"
yearOfBirth	1980
wizard	true
ancestry	"half-blood"
eyeColour	"green"
hairColour	"black"
wand
wood	"holly"
core	"phoenix feather"
length	11
patronus	"stag"
hogwartsStudent	true
hogwartsStaff	false
actor	"Daniel Radcliffe"
alternate_actors	[]
alive	true
image	"https://ik.imagekit.io/hpapi/harry.jpg"*/

data class CharacterData(
    val id :String,
    val name: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val ancestry: String,
    val patronus:String,
    val actor: String,
    val alive : Boolean,
    val image : String
)
