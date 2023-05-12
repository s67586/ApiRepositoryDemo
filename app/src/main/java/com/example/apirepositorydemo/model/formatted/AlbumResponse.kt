package com.example.apirepositorydemo.model.formatted

import android.os.Parcelable
import com.example.apirepositorydemo.constant.RetrofitStatus
import com.example.apirepositorydemo.model.response.Album
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumResponse(
    val status: RetrofitStatus = RetrofitStatus.UNKNOWN,
    val albums: List<Album>? = null
) : Parcelable