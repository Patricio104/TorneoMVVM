package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Match(
    val id: Int = 0,
    val idTeam1: Int = 0,
    val idTeam2: Int = 0,
    val pointsTeam1: Int = 0,
    val pointsTeam2: Int = 0,
    val idTorneo: Int = 0
)

data class MatchList(val results: List<Team> = listOf())

@Entity
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "idTeam1")
    val idTeam1: Int = 0,
    @ColumnInfo(name = "idTeam2")
    val idTeam2: Int = 0,
    @ColumnInfo(name = "pointsTeam1")
    val pointsTeam1: Int = 0,
    @ColumnInfo(name = "pointsTeam2")
    val pointsTeam2: Int = 0,
    @ColumnInfo(name = "idTorneo")
    val idTorneo: Int = 0
)