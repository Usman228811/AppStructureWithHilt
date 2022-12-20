package com.example.myfirstapp.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.room.Room
import com.example.myfirstapp.data.room.WordDao
import com.example.myfirstapp.data.room.db.WordRoomDatabase
import com.example.myfirstapp.utils.MyPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesSharedPref(@ApplicationContext context: Context) =
        MyPref(context)


    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context): WordRoomDatabase =
        Room.databaseBuilder(
            context,
            WordRoomDatabase::class.java,
            "word_database"
        ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun providesWordDao(wordRoomDatabase: WordRoomDatabase): WordDao =
        wordRoomDatabase.wordDao()


    @Singleton
    @Provides
    fun providesConnectivityManager(@ApplicationContext context: Context): ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


}