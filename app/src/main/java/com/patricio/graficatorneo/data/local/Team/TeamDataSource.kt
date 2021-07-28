package com.patricio.graficatorneo.data.local.Team

import com.patricio.graficatorneo.data.model.TeamList
import com.patricio.graficatorneo.data.model.toTeamList

class TeamDataSource(private val teamDao: TeamDao) {
    //Aqui se llamaran los datos desde room
    suspend fun getTeams(): TeamList = teamDao.getAllTeams().filter { it.status == 0 }.toTeamList()

    fun getTeamLosing(): TeamList{
        return TeamList()
    }

    fun getTeamWinning(): TeamList{
        return TeamList()
    }
}