package com.patricio.graficatorneo.data.local.Torneo

import com.patricio.graficatorneo.data.model.TorneoEntity
import com.patricio.graficatorneo.data.model.TorneoList
import com.patricio.graficatorneo.data.model.toTorneoList

class TorneoDataSource (private val torneoDao: TorneoDao){
    //Aqui se llamaran los datos desde room
    suspend fun getTorneos(): TorneoList{
        return torneoDao.getAllToneos().toTorneoList()
    }

    fun getTorneoLosing(): TorneoList {
        return TorneoList()
    }

    fun getTorneoWinning(): TorneoList {
        return TorneoList()
    }

    suspend fun saveTorneo(torneo: TorneoEntity){
        torneoDao.saveTorneo(torneo)
    }
}