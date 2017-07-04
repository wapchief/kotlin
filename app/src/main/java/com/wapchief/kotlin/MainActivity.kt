package com.wapchief.kotlin

import android.app.ActionBar
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.main_tablayout.*
import kotlinx.android.synthetic.main.main_header.*
import android.graphics.Color.parseColor
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.PagerTabStrip
import android.support.v4.view.ViewPager
import android.support.v7.view.SupportActionModeWrapper
import android.view.View
import java.util.*


class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    /*初始化相关*/
    private fun initView() {
        initFragment()
        initOnClick()
    }

    /*fragment*/
    private fun initFragment() {
        var fragments: MutableList<Fragment> = ArrayList<Fragment>()
        fragments.add(Fragment1())
        fragments.add(Fragment1());
        fragments.add(Fragment1());
        vp.adapter = viewPagerAdapter(supportFragmentManager, fragments)
        //为viewpager设置页面滑动监听
        vp.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                //判断滑动后选择的页面设置相应的RadioButton被选中
                when (position) {
                //这里的btn_one two the 分别是布局中的三个RadioButton的id，直接调用其方法进行设置
                    0 -> {
                        initTabLayout(tab1_tv, tab1_v)
                        clearTabLayout(tab2_tv, tab2_v)
                        clearTabLayout(tab3_tv, tab3_v)
                    }
                //当只是写btn_one.isChecked获取的是它的选中状态，如果让它 =true 就会默认调用setChecked()方法进行改变状态
                    1 -> {
                        initTabLayout(tab2_tv, tab2_v)
                        clearTabLayout(tab1_tv, tab1_v)
                        clearTabLayout(tab3_tv, tab3_v)
                    }
                    2 -> {
                        initTabLayout(tab3_tv, tab3_v)
                        clearTabLayout(tab2_tv, tab2_v)
                        clearTabLayout(tab1_tv, tab1_v)
                    }
                }
            }

        })


    }

    /*监听*/
    private fun initOnClick() {
        /*关联选择器*/
        tab1.setOnClickListener {
            vp.setCurrentItem(0)
            initTabLayout(tab1_tv, tab1_v)
            clearTabLayout(tab2_tv, tab2_v)
            clearTabLayout(tab3_tv, tab3_v)
        }
        tab2.setOnClickListener {
            vp.setCurrentItem(1)
            initTabLayout(tab2_tv, tab2_v)
            clearTabLayout(tab1_tv, tab1_v)
            clearTabLayout(tab3_tv, tab3_v)
        }
        tab3.setOnClickListener {
            vp.setCurrentItem(2)
            initTabLayout(tab3_tv, tab3_v)
            clearTabLayout(tab2_tv, tab2_v)
            clearTabLayout(tab1_tv, tab1_v)
        }
        header_an.setOnClickListener {
            header_1.visibility = View.GONE
            header_2.visibility = View.VISIBLE
            header_an.visibility = View.GONE
        }
    }

    /*初始化tab标签*/
    private fun initTabLayout(tv: TextView, tv2: TextView) {
        tv.setTextColor(resources.getColor(R.color.tab_select))
        tv2.setBackgroundColor(resources.getColor(R.color.tab_select))
    }

    /*重置tab标签颜色*/
    private fun clearTabLayout(tv: TextView, tv2: TextView) {
        tv.setTextColor(resources.getColor(R.color.tab_clear))
        tv2.setBackgroundColor(Color.WHITE)
    }

    //继承 FragmentPagerAdapter 创建适配器
    class viewPagerAdapter(fm: FragmentManager?, var list: List<Fragment>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }
    }

}






