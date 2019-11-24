package com.urtisi.baget.feed

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.urtisi.baget.util.RSSModel

class FeedViewModel : ViewModel() {

    var feedList = MutableLiveData<ArrayList<RSSModel>>()
    val repository = FeedRepository()

    init {
        loadData()
    }

    fun loadData(){
        repository.getData(object : OnDataReadyCallback{
            override fun onDataReady(data: ArrayList<RSSModel>) {
                feedList.value = data
            }
        })
    }
}