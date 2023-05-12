package com.example.apirepositorydemo.ui.list.adapter

import com.example.apirepositorydemo.model.response.Album

interface AlbumListListener {

    fun onItemClick(album: Album)
}