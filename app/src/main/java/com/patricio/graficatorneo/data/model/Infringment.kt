package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Infringment(
    val id: Int = 0,
    val name: String = ""
)

data class InfringmentList(val results: List<Team> = listOf())

@Entity
data class InfringmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name="name")
    val name: String = ""
)

