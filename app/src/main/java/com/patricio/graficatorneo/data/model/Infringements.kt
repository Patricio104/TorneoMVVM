package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Infringements(
    val id: Int = -1,
    val idMatch: Int = -1,
    val idPlayer: Int = -1,
    val idTypeInfringment: Int = -1
)

data class InfrigmentsList(val results: List<Team> = listOf())

@Entity
data class InfringmentsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    @ColumnInfo(name = "idMatch")
    val idMatch: Int = -1,
    @ColumnInfo(name = "idPlayer")
    val idPlayer: Int = -1,
    @ColumnInfo(name = "idTypeInfringment")
    val idTypeInfringment: Int = -1
)