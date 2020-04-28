package com.algokelvin.n_pocket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var typePocket = "money"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pocketViewPageAdapter = AppsViewPageAdapter(supportFragmentManager)
        pocketViewPageAdapter.addAppsPage(MoneyFragment(), GopayFragment(), OvoFragment())
        layoutViewPager.adapter = pocketViewPageAdapter

        floating_action_input_pocket.setOnClickListener {
            val toInputPocket = Intent(this, InputPocketActivity::class.java)
            toInputPocket.putExtra("type_pocket_data", typePocket)
            startActivity(toInputPocket)
            finish()
        }

        tabs_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) { }
            override fun onTabUnselected(p0: TabLayout.Tab?) { }
            override fun onTabSelected(p0: TabLayout.Tab?) {
                layoutViewPager.setCurrentItem(p0?.position!!, true)
                typePocket = p0.text.toString()
            }
        })
    }
}
