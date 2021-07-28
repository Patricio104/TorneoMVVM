package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Player(
    val id : Int = -1,
    val name: String = "",
    val idTeam: Int =-1
)

data class PlayerList(val results: List<Team> = listOf())

@Entity
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int=-1,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "idTeam")
    val idTeam: Int =-1
)