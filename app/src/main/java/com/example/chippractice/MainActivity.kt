package com.example.chippractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.example.chippractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btmviewpagerAdapter: ClassBtmViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root


        btmviewpagerAdapter = ClassBtmViewpagerAdapter(supportFragmentManager)
        btmviewpagerAdapter.fragments = listOf(
            ClassBtmFirstFragment(),
            ClassBtmSecondFragment(),
            ClassBtmThirdFragment(),
            ClassBtmFourthFragment()
        )

        //class_btm_tab_viewpager.adapter = btmviewpagerAdapter
        binding.classBtmTabViewpager.adapter=btmviewpagerAdapter

        /*
        class_btm_tab.setupWithViewPager(class_btm_tab_viewpager)
        class_btm_tab.apply{
            getTabAt(0)?.text = "인기 작품"
            getTabAt(1)?.text = "최신 작품"
            getTabAt(2)?.text = "인기 후기"
            getTabAt(3)?.text = "작가 추천"
        }*/

        binding.classBtmTab.setupWithViewPager(binding.classBtmTabViewpager)
        binding.classBtmTab.apply{
            getTabAt(0)?.text = "인기 작품"
            getTabAt(1)?.text = "최신 작품"
            getTabAt(2)?.text = "인기 후기"
            getTabAt(3)?.text = "작가 추천"
        }

        for (i in 0 until binding.classBtmTab.getTabCount()) {
            val tab = (binding.classBtmTab.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(4, 0, 4, 0)
            tab.requestLayout()
        }
        setContentView(view)
    }

}