package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class TypePoint(
    val id:Int=-1,
    val type: String="",
    val value: Int=-1
)

data class TypePointList(val results: List<Team> = listOf())

@Entity
data class TypePointEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=-1,
    @ColumnInfo(name = "type")
    val type: String="",
    @ColumnInfo(name = "value")
    val value: Int=-1
)

