package com.dozkan.surveyapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val nameSurname: String,
    val email: String,
    val age: String,
    val phoneNum: String
) : Parcelable