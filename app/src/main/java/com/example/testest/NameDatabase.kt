package com.example.testest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Name::class], version = 1)
abstract class NameDatabase: RoomDatabase() {
    abstract fun testDao(): NameDao
}