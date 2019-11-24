package com.urtisi.baget.dashboard

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    var repository = DashboardRepository()
    val neText = MutableLiveData<String>()
    val text = ObservableField<String>()

    init {
        loadData()
    }

    fun loadData(){
        repository.getData(object : OnDataReadyCallback{
            override fun onDataReady(data: String) {
                text.set(data)
//                neText.value = data
            }
        })
    }

}