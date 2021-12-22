package com.example.iihfstatisticandnews.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iihfstatisticandnews.data.models.NewsDbModel
import com.example.iihfstatisticandnews.data.models.StadiumDbModel
import com.example.iihfstatisticandnews.data.models.TeamDbModel
import com.example.iihfstatisticandnews.data.models.TourneyDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM tourney_info")
    fun getTourneyList(): LiveData<List<TourneyDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourneyList(tourneys: List<TourneyDbModel>)

    @Query("SELECT * FROM stadium_info")
    fun getStadiumList(): LiveData<List<StadiumDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStadiumList(stadiums: List<StadiumDbModel>)

    @Query("SELECT * FROM news_info")
    fun getNewsList(): LiveData<List<NewsDbModel>>

    @Query("SELECT * FROM news_info WHERE title ==:title")
    fun getNews(title: String): LiveData<NewsDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(news: List<NewsDbModel>)

    @Query("SELECT * FROM team_info")
    fun getTeamList(): LiveData<List<TeamDbModel>>

    @Query("SELECT * FROM team_info WHERE country ==:country")
    fun getTeam(country: String): LiveData<TeamDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(teams: List<TeamDbModel>)

}