package com.example.myfirstapp.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.room.Room
import com.example.myfirstapp.data.api.remote.Posts
import com.example.myfirstapp.data.room.WordDao
import com.example.myfirstapp.data.room.db.WordRoomDatabase
import com.example.myfirstapp.utils.BASE_URL
import com.example.myfirstapp.utils.MyPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Singleton
    @Provides
    fun providesRetrofit(@ApplicationContext context: Context): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesPostsService(retrofit: Retrofit): Posts =
        retrofit.create(
            Posts::class.java
        )


}