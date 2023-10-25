package com.example.hse

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Activity(
    @Json(name = "activity")
    val activity: String,
    @Json(name = "link")
    val link: String,
    /*
    @Json(name = "price")
    val price: String,
    @Json(name = "accessibility")
    val accessibility: String,*/
)
