package com.example.testest

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.UUID

@Dao
interface NameDao {
    @Query("SELECT * FROM name")
    fun getNames(): LiveData<List<Name>>

    @Query("SELECT * FROM name WHERE id=(:id)")
    fun getName(id: UUID): LiveData<Name?>

    @Insert
    fun addName(name: Name)
}