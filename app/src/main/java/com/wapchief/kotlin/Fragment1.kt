package com.wapchief.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment1.view.*
import java.util.*


/**
 * Created by apple on 2017/7/3.
 */
class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment1, container, false)

        view.lv.adapter=
            activity?.let { ArrayAdapter(it, android.R.layout.simple_expandable_list_item_1, getData()) }

        return view

    }
    private fun getData(): List<String> {

        val data = ArrayList<String>()
        for (i in 0..30) {
            data.add(i,"测试数据："+i)
        }
        return data
    }
}