
package com.example.hospitaltriage

import androidx.room.*

@Dao
interface PatientDao {

    @Insert
    fun insert(patient: Patient)

    @Query("SELECT * FROM Patient ORDER BY id DESC")
    fun getAll(): List<Patient>

    @Query("SELECT COUNT(*) FROM Patient WHERE triageLevel = :level")
    fun countByLevel(level: Int): Int
}
