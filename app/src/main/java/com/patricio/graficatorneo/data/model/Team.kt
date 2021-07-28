package com.patricio.graficatorneo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Team(
    val id: Int = -1,
    val name: String = "",
    val status: Int = 0
)

data class TeamList(val results: List<Team> = listOf())

//Room
@Entity
data class TeamEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "status")
    val status: Int= 0
)

fun List<TeamEntity>.toTeamList(): TeamList{
    val resultList = mutableListOf<Team>()
    this.forEach { teamEntity ->
        resultList.add(teamEntity.toTeam())
    }
    return TeamList(resultList)
}

fun TeamEntity.toTeam (): Team = Team(
    this.id,
    this.name,
    this.status
)

fun Team.toTeamEntity (teamType: String): TeamEntity = TeamEntity(
    this.id,
    this.name,
    this.status
)