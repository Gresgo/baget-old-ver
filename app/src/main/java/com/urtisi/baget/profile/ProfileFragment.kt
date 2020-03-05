package com.urtisi.baget.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.urtisi.baget.R

class ProfileFragment : Fragment() {

    /**
     * main fragment for profile screen
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_umk, container, false)

        return view
    }

}