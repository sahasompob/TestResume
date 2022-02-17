package com.example.testanymind.data.model

import com.google.gson.annotations.SerializedName

data class Skill(
    @SerializedName("skillName")
    val name:String
)