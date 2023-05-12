package com.example.apirepositorydemo.ui.list

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.apirepositorydemo.R
import com.example.apirepositorydemo.constant.RetrofitStatus
import com.example.apirepositorydemo.databinding.ActivityListBinding
import com.example.apirepositorydemo.model.response.Album
import com.example.apirepositorydemo.ui.list.adapter.AlbumListAdapter
import com.example.apirepositorydemo.ui.list.adapter.AlbumListListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListActivity : AppCompatActivity(), AlbumListListener {

    private val listViewModel: ListViewModel by viewModels()
    private lateinit var activityListBinding: ActivityListBinding
    @Inject lateinit var albumListAdapter: AlbumListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        listViewModel.albums.observe(this, Observer { response ->
            when(response.status) {
                RetrofitStatus.SUCCESS -> response.albums?.let { albums ->
                    albumListAdapter.setAlbums(albums, this)
                    activityListBinding.textError.visibility = View.GONE
                    activityListBinding.recyclerview.visibility = View.VISIBLE
                }
                else -> {
                    activityListBinding.textError.text = resources.getString(R.string.text_error)
                    activityListBinding.recyclerview.visibility = View.GONE
                    activityListBinding.textError.visibility = View.VISIBLE
                }
            }
            activityListBinding.swipeRefreshLayout.isRefreshing = false
        })
        activityListBinding.recyclerview.apply {
            adapter = albumListAdapter
            setHasFixedSize(true)
        }
        activityListBinding.swipeRefreshLayout.setOnRefreshListener {
            listViewModel.getAlbums()
        }
        activityListBinding.swipeRefreshLayout.isRefreshing = true
    }

    override fun onItemClick(album: Album) {

    }
}