package com.patricio.graficatorneo.repository.Torneo

import com.patricio.graficatorneo.data.local.Torneo.TorneoDataSource
import com.patricio.graficatorneo.data.model.TorneoEntity
import com.patricio.graficatorneo.data.model.TorneoList

class TorneoRepositoryImpl(private val dataSourceLocal: TorneoDataSource) :TorneoRepository {
    override suspend fun getToneos(): TorneoList {
       return dataSourceLocal.getTorneos()
    }
    override suspend fun getTorneosFinalize(): TorneoList {
        return dataSourceLocal.getTorneoLosing()
    }

    override suspend fun getTorneosProccess(): TorneoList {
        return dataSourceLocal.getTorneoLosing()
    }

    override suspend fun insertTorneo(torneo: TorneoEntity) {
        dataSourceLocal.saveTorneo(torneo)
    }

    override suspend fun updateTorneo() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTorneo() {
        TODO("Not yet implemented")
    }
}