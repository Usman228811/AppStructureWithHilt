package com.example.myfirstapp.di

import android.app.Activity
import android.content.Context
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.databinding.ActivityRoomDbTestBinding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityScoped
    @Provides
    fun providesActivityMainBinding(@ActivityContext context: Context) =
        ActivityMainBinding.inflate((context as Activity).layoutInflater)

    @ActivityScoped
    @Provides
    fun providesActivityRoomDbTestBinding(@ActivityContext context: Context) =
        ActivityRoomDbTestBinding.inflate((context as Activity).layoutInflater)


}