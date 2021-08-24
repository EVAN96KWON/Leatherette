package com.buttup.leatherette.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buttup.leatherette.R

class Matching : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedIntanceState: Bundle?
    ) : View? {
        return inflater.inflate(R.layout.fragment_matching, container, false)
    }
}