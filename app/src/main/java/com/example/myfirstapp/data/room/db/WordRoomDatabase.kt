package com.example.myfirstapp.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfirstapp.data.room.Word
import com.example.myfirstapp.data.room.WordDao

@Database(entities = [Word::class], version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
}