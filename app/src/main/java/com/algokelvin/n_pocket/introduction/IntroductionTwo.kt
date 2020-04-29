package com.algokelvin.n_pocket.introduction

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.algokelvin.n_pocket.R
import com.algokelvin.utils.layout.IntroductionFragment
import kotlinx.android.synthetic.main.fragment_introduction_two.*

class IntroductionTwo : IntroductionFragment(R.layout.fragment_introduction_two) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharePreferences = context?.getSharedPreferences("profile", Context.MODE_PRIVATE)
        val pref = sharePreferences?.edit()
        btn_submit_profile.setOnClickListener {
            pref?.putString("name", name_profile.text.toString())
                ?.putString("phone", no_phone_profile.text.toString())
                ?.apply()
            Toast.makeText(requireContext(), "Success Submit Your Profile", Toast.LENGTH_LONG).show()
        }
    }
}
