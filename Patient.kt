
package com.example.hospitaltriage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Patient(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val gestationalAge: Int,
    val sbp: Int,
    val dbp: Int,
    val hr: Int,
    val rr: Int,
    val spo2: Double,
    val temp: Double,
    val vas: Int,
    val bleeding: Boolean,
    val labor: Boolean,
    val fetalDistress: Boolean,
    val triageLevel: Int
)
