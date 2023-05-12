package com.example.apirepositorydemo.dao.remote

import com.example.apirepositorydemo.model.response.Album
import retrofit2.http.GET

interface RemoteAlbumDao {

    @GET("albums/1/photos")
    suspend fun getAlbums() : List<Album>
}