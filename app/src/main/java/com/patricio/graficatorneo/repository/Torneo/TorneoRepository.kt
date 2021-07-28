package com.patricio.graficatorneo.repository.Torneo

import com.patricio.graficatorneo.data.model.TorneoEntity
import com.patricio.graficatorneo.data.model.TorneoList

interface TorneoRepository {
    suspend fun getToneos(): TorneoList
    suspend fun getTorneosFinalize(): TorneoList
    suspend fun getTorneosProccess(): TorneoList
    suspend fun updateTorneo()
    suspend fun deleteTorneo()
    suspend fun insertTorneo(torneo: TorneoEntity)
}