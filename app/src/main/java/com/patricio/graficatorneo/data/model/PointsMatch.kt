package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class PointsMatch(
    val id :Int =-1,
    val idMatch: Int =-1,
    val idPlayer: Int =-1,
    val idTypePoint: Int =-1
)

data class PointsMatchList(val results: List<Team> = listOf())

@Entity
data class PointsMatchEntity(
    @PrimaryKey(autoGenerate = true)
    val id :Int =-1,
    @ColumnInfo( name= "idMatch")
    val idMatch: Int =-1,
    @ColumnInfo( name= "idPlayer")
    val idPlayer: Int =-1,
    @ColumnInfo( name= "idTypePoint")
    val idTypePoint: Int =-1
)
