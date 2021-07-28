package com.patricio.graficatorneo.repository.Team

import com.patricio.graficatorneo.data.model.TeamList

interface TeamRepository {
    suspend fun getTeams(): TeamList
    suspend fun getTeamsLosing(): TeamList
    suspend fun getTeamsWinning(): TeamList
}