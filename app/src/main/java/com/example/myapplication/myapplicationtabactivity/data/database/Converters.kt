package com.example.myapplication.myapplicationtabactivity.data.database

import androidx.room.TypeConverter
import com.example.myapplication.myapplicationtabactivity.data.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source):String {
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source {
        return Source(name,name)
    }
}