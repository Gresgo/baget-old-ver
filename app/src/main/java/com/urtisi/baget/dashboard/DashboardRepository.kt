package com.urtisi.baget.dashboard

import android.os.Handler

class DashboardRepository {

    fun getData(onDataReadyCallback: OnDataReadyCallback){
            Handler().postDelayed({
                onDataReadyCallback.onDataReady("This is Dashboard!")
            }, 3000)
    }
}

interface OnDataReadyCallback{
    fun onDataReady(data: String)
}