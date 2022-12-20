package com.example.myfirstapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Query("DELETE FROM word_table where id=:id")
    suspend fun deleteById(id:Int)

    @Query("SELECT * FROM word_table order by id desc")
    fun getAlphabetizedWords(): Flow<List<Word>>
}