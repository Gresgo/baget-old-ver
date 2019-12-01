package com.urtisi.baget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.urtisi.baget.databinding.FragmentNewsMainBinding
import com.urtisi.baget.feed.FeedFragment
import com.urtisi.baget.vk.VKFragment

class MainNewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_main, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsPager.adapter = PagerAdapter(fragmentManager!!)
        binding.newsTab.setupWithViewPager(binding.newsPager)
    }

    class PagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

        private val pageCount = 2
        private val titles = arrayOf("site", "vk")
        private val fragments = arrayOf(FeedFragment(), VKFragment())

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = pageCount

        override fun getPageTitle(position: Int): CharSequence? = titles[position]

    }
}

