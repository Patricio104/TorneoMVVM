package com.patricio.graficatorneo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patricio.graficatorneo.data.local.Team.TeamDao
import com.patricio.graficatorneo.data.local.Torneo.TorneoDao
import com.patricio.graficatorneo.data.model.*

@Database(entities = [TorneoEntity::class,
    StatusEntity::class,
    TypePointEntity::class,
    InfringmentEntity::class,
    TeamEntity::class,
    PlayerEntity::class,
    PointsMatchEntity::class,
    MatchEntity::class,
    InfringmentsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun torneoDao(): TorneoDao
    abstract fun teamDao(): TeamDao

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "bd_torneo"
            ).build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE=null
        }
    }
}