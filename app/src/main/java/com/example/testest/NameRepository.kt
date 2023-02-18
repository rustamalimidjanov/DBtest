package com.example.testest

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "month-database"

class NameRepository private constructor(context: Context){

    private val database: NameDatabase = Room.databaseBuilder(
        context.applicationContext,
        NameDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val testDao = database.testDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getNames(): LiveData<List<Name>> = testDao.getNames()
    fun getName(id: UUID): LiveData<Name?> = testDao.getName(id = id)
    fun addName(name: Name) {
        executor.execute {
            testDao.addName(name = name)
        }
    }

    companion object {
        private var INSTANCE: NameRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = NameRepository(context = context)
            }
        }

        fun get(): NameRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}