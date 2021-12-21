package com.example.iihfstatisticandnews.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.iihfstatisticandnews.data.models.NewsDbModel
import com.example.iihfstatisticandnews.data.models.StadiumDbModel
import com.example.iihfstatisticandnews.data.models.TourneyDbModel

@Database(
    entities = [
        TourneyDbModel::class,
        StadiumDbModel::class,
        NewsDbModel::class
    ],
    version = 2, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private const val DB_NAME = "iihf.db"
        private var database: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                database?.let {
                    return it
                }
                val instance = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                database = instance
                return instance
            }
        }
    }

    abstract fun dbDao(): DbDao
}