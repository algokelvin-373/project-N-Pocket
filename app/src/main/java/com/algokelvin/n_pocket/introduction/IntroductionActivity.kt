package com.algokelvin.n_pocket.introduction

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.algokelvin.n_pocket.AppsViewPageAdapter
import com.algokelvin.n_pocket.MainActivity
import com.algokelvin.n_pocket.R
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : AppCompatActivity() {
    private var itemPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharePreference = getSharedPreferences("profile", Context.MODE_PRIVATE)
        if (sharePreference.getString("name", null) != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_introduction)
        }

        val introductionViewPageAdapter = AppsViewPageAdapter(supportFragmentManager)
        introductionViewPageAdapter.addAppsPage(IntroductionOne(), IntroductionTwo(), IntroductionThree())
        layoutViewPagerIntroduction.adapter = introductionViewPageAdapter

        text_back.setOnClickListener {
            if (itemPage > 0) itemPage--
            layoutViewPagerIntroduction.setCurrentItem(itemPage, true)
            if (itemPage != 2) text_next.visibility = View.VISIBLE
            if (itemPage == 0) text_back.visibility = View.GONE
        }
        text_next.setOnClickListener {
            if (itemPage < 2) itemPage++
            layoutViewPagerIntroduction.setCurrentItem(itemPage, true)
            if (itemPage == 2) text_next.visibility = View.GONE
            if (itemPage != 0) text_back.visibility = View.VISIBLE
        }
    }
}
