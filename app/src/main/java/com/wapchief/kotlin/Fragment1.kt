package com.wapchief.kotlin

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment1.*
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment1.view.*
import java.util.*


/**
 * Created by apple on 2017/7/3.
 */
class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment1, container, false)

        view.lv.adapter=ArrayAdapter(activity, android.R.layout.simple_expandable_list_item_1, getData())

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