package com.urtisi.baget.feed

import com.urtisi.baget.util.RSSModel
import com.urtisi.baget.util.RSSParser


class FeedRepository {

    fun getData(onDataReadyCallback: OnRSSReadyCallback){
    }

}

interface OnRSSReadyCallback{
    fun onDataReady(data: ArrayList<RSSModel>)
}