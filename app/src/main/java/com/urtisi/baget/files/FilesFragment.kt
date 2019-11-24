package com.urtisi.baget.files

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.urtisi.baget.R
import kotlinx.android.synthetic.main.fragment_files.view.*

class FilesFragment : Fragment() {

    private lateinit var filesViewModel: FilesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        filesViewModel = ViewModelProviders.of(this).get(FilesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_files, container, false)
        val textView: TextView = root.text_notifications

        filesViewModel.text.observe(this, Observer {
            textView.text = it
        })

        return root
    }
}