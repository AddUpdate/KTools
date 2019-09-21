package com.jiangkang.anko.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jiangkang.anko.R

class AnkoMainFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = AnkoMainFragment()
    }

    private lateinit var viewModel: AnkoMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {


        return inflater.inflate(R.layout.anko_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AnkoMainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
