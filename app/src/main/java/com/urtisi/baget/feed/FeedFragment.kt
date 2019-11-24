package com.urtisi.baget.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.urtisi.baget.R
import com.urtisi.baget.databinding.FragmentFeedBinding
import com.urtisi.baget.util.RSSModel
import kotlinx.android.synthetic.main.fragment_feed.view.*

class FeedFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var binding: FragmentFeedBinding
    private val RSSViewAdapter = RSSAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false)
        binding.viewModel = feedViewModel
        binding.executePendingBindings()

        binding.feedRecView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        binding.feedRecView.adapter = RSSViewAdapter

        feedViewModel.feedList.observe(this, Observer<ArrayList<RSSModel>>{
            it?.let { RSSViewAdapter.replaceData(it) }
        })

        return binding.root
    }
}