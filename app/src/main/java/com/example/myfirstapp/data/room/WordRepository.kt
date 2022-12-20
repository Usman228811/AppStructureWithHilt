package com.example.myfirstapp.data.room

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository
@Inject
constructor(private val wordDao: WordDao) {

    val allWords = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
    suspend fun deleteById(id: Int) {
        wordDao.deleteById(id)
    }
}