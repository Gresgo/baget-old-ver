package com.urtisi.baget.feed

import com.urtisi.baget.util.RSSModel
import com.urtisi.baget.util.RSSParser


class FeedRepository {

    fun getData(onDataReadyCallback: OnDataReadyCallback){
        val rss = RSSParser()
        rss.execute()
        onDataReadyCallback.onDataReady(rss.get())
    }
}

interface OnDataReadyCallback{
    fun onDataReady(data: ArrayList<RSSModel>)
}