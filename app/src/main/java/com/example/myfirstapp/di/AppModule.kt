package com.example.myfirstapp.di

import android.content.Context
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
}