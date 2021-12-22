package com.example.iihfstatisticandnews.data.converters

import androidx.room.TypeConverter
import com.example.iihfstatisticandnews.domain.pojo.MatchItem
import com.example.iihfstatisticandnews.domain.pojo.PlayerItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class TeamConverter {
    @TypeConverter
    fun toListFromJsonPlayers(players:String):List<PlayerItem>{
        if(players == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<PlayerItem>>(){}.type
        return Gson().fromJson(players,type)
    }
    @TypeConverter
    fun fromJsonToListPlayers(players:List<PlayerItem>):String{
        return Gson().toJson(players)
    }

    @TypeConverter
    fun toListFromJsonMatches(matches:String):List<MatchItem>{
        if(matches == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<MatchItem>>(){}.type
        return Gson().fromJson(matches,type)
    }
    @TypeConverter
    fun fromJsonToListMatches(matches:List<MatchItem>):String{
        return Gson().toJson(matches)
    }
}