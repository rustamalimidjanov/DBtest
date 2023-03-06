package com.example.testest

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Name(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var name: String = "",
)
