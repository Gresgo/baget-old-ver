package com.urtisi.baget.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.urtisi.baget.databinding.FeedItemBinding
import com.urtisi.baget.util.RSSModel

class RSSAdapter(private var feedList: ArrayList<RSSModel>) : RecyclerView.Adapter<RSSAdapter.RSSHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RSSHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = FeedItemBinding.inflate(inflater, parent, false)
        return RSSHolder(binding)
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: RSSHolder, position: Int) {
        val feed = feedList[position]
        holder.bind(feed)
    }

    fun replaceData(arrayList: ArrayList<RSSModel>){
        feedList = arrayList
        notifyDataSetChanged()
    }


    class RSSHolder(private var binding: FeedItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(rss: RSSModel){
            binding.feedItem = rss
            binding.executePendingBindings()
        }

    }

}