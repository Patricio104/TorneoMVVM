package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Torneo(
    val id:Int =-1,
    val name: String = "",
    val date: String=""
)

data class TorneoList(val results: List<Torneo> = listOf())

@Entity
data class TorneoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int =-1,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "date")
    val date: String=""
)


fun List<TorneoEntity>.toTorneoList(): TorneoList{
    val resultList = mutableListOf<Torneo>()
    this.forEach { torneoEntity ->
        resultList.add(torneoEntity.toTorneo())
    }
    return TorneoList(resultList)
}

fun TorneoEntity.toTorneo (): Torneo = Torneo(
    this.id,
    this.name,
    this.date
)

fun Torneo.toTorneoEntity (teamType: String): TorneoEntity = TorneoEntity(
    this.id,
    this.name,
    this.date
)
