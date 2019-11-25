package com.urtisi.baget.feed


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.urtisi.baget.util.RSSModel
import com.urtisi.baget.util.RSSParser

class FeedViewModel : ViewModel(), OnRSSReadyCallback {

    var feedList = MutableLiveData<ArrayList<RSSModel>>()
    private val repository = FeedRepository()

    init {
        loadData()
    }

    fun loadData(){
        val rss = RSSParser(this)
        rss.execute()
    }

    override fun onDataReady(data: ArrayList<RSSModel>) {
        feedList.value = data
    }
}