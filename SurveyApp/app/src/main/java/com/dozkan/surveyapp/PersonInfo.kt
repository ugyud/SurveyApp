package com.dozkan.surveyapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonInfo(
    val movie: String,
    val singer: String,
    val meal: String,
    val person: Person
) : Parcelable