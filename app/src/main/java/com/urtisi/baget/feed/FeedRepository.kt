package com.urtisi.baget.feed

import com.urtisi.baget.util.RSSModel
import com.urtisi.baget.util.RSSParser


class FeedRepository {

    fun getData(onDataReadyCallback: OnRSSReadyCallback){
//        val rss = RSSParser(this)
//        rss.execute()
//        onDataReadyCallback.onDataReady(rss.get())
    }

}

interface OnRSSReadyCallback{
    fun onDataReady(data: ArrayList<RSSModel>)
}