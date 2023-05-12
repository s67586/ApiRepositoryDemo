package com.example.apirepositorydemo.database.remote

import com.example.apirepositorydemo.dao.remote.RemoteAlbumDao
import com.example.apirepositorydemo.utils.Retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RemoteDatabase {

    @Provides
    @Singleton
    fun provideAlbumDAO(): RemoteAlbumDao = Retrofit.getClient().create(RemoteAlbumDao::class.java)
}