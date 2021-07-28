package com.patricio.graficatorneo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.patricio.graficatorneo.core.Resource
import com.patricio.graficatorneo.repository.Team.TeamRepository
import kotlinx.coroutines.Dispatchers

class TeamViewModel(private val repo: TeamRepository) : ViewModel(){
    fun fetchMainScreenMovies()=liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success((repo.getTeams())))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class TeamViewModelFactory(private val repo: TeamRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TeamRepository::class.java).newInstance(repo)
    }

}