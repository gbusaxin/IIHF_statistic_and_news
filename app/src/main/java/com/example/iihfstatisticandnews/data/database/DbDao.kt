package com.example.iihfstatisticandnews.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iihfstatisticandnews.data.models.TourneyDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM tourney_info")
    fun getTourneyList(): LiveData<List<TourneyDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourneyList(tourneys: List<TourneyDbModel>)

}