package com.urtisi.baget.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.urtisi.baget.R
import com.urtisi.baget.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        retainInstance = true
//        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
//        binding.viewModel = dashboardViewModel
//        binding.executePendingBindings()

//        dashboardViewModel.text.observe(this, Observer {
//            textView.text = it
//        })

        return binding.root
    }
}