package com.patricio.graficatorneo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.patricio.graficatorneo.core.Resource
import com.patricio.graficatorneo.data.model.TorneoEntity
import com.patricio.graficatorneo.repository.Team.TeamRepository
import com.patricio.graficatorneo.repository.Torneo.TorneoRepository
import kotlinx.coroutines.Dispatchers

class TorneoViewModel(private val repo: TorneoRepository): ViewModel() {
    fun fetchMainToneos()= liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success((repo.getToneos())))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun insertTorneo(torneo: TorneoEntity) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success((repo.insertTorneo(torneo))))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}


class TorneoViewModelFactory(private val repo: TorneoRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TorneoRepository::class.java).newInstance(repo)
    }

}