package com.patricio.graficatorneo.data.local.Team

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.patricio.graficatorneo.data.model.TeamEntity

@Dao
interface TeamDao {
    @Query("SELECT * FROM teamentity")
    suspend fun getAllTeams(): List<TeamEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTeam(team: TeamEntity)
}