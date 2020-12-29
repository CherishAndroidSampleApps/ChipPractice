package com.example.chippractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.androidwithdesign.ClassBtmFirstFragment
import com.example.chippractice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    private lateinit var btmviewpagerAdapter: ClassBtmViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view) 뷰 바인딩 사용의 실패 흔적...

        btmviewpagerAdapter = ClassBtmViewpagerAdapter(supportFragmentManager)
        btmviewpagerAdapter.fragments = listOf(
            ClassBtmFirstFragment(),
            ClassBtmSecondFragment(),
            ClassBtmThirdFragment(),
            ClassBtmFourthFragment()
        )

        class_btm_tab_viewpager.adapter = btmviewpagerAdapter

        class_btm_tab.setupWithViewPager(class_btm_tab_viewpager)
        class_btm_tab.apply{
            getTabAt(0)?.text = "인기 작품"
            getTabAt(1)?.text = "최신 작품"
            getTabAt(2)?.text = "인기 후기"
            getTabAt(3)?.text = "작가 추천"
        }

        for (i in 0 until class_btm_tab.getTabCount()) {
            val tab = (class_btm_tab.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(4, 0, 4, 0)
            tab.requestLayout()
        }
    }
}