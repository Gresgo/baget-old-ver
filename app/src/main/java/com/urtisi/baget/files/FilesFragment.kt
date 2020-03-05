package com.urtisi.baget.files

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.urtisi.baget.R
import com.urtisi.baget.databinding.FragmentFilesBinding

class FilesFragment : Fragment() {

    private lateinit var filesViewModel: FilesViewModel
    private lateinit var binding: FragmentFilesBinding
    private lateinit var fileName: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        filesViewModel = ViewModelProviders.of(this).get(FilesViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_files, container, false)
        binding.viewModel = filesViewModel
        binding.executePendingBindings()

        /**
         * load list of files from nextcloud
         * context for create client (change?)
         */
        filesViewModel.loadData(context!!)

        return binding.root
    }

}