package com.algokelvin.n_pocket.introduction

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.algokelvin.n_pocket.MainActivity
import com.algokelvin.n_pocket.R
import com.algokelvin.utils.db.entity.PocketEntity
import com.algokelvin.utils.getDate
import com.algokelvin.utils.layout.IntroductionFragment
import com.algokelvin.utils.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.fragment_introduction_three.*

class IntroductionThree : IntroductionFragment(R.layout.fragment_introduction_three) {
    private val pocketViewModel by lazy {
        ViewModelProviders.of(this).get(PocketViewModel::class.java)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_balance_begin.setOnClickListener {
            val date = getDate("dd MMM yyyy")
            val balanceMoney = PocketEntity(("11"+"26"+"04"+"2020"+(0..100).random()).toLong(), date,
                money_balance.text.toString().toInt(), "Saldo Awal Uang", "money")
            val balanceGopay = PocketEntity(("11"+"26"+"04"+"2020"+(0..100).random()).toLong(), date,
                money_balance.text.toString().toInt(), "Saldo Awal GOPAY", "gopay")
            val balanceOvo = PocketEntity(("11"+"26"+"04"+"2020"+(0..100).random()).toLong(), date,
                money_balance.text.toString().toInt(), "Saldo Awal OVO", "ovo")
            pocketViewModel.insertNotePocket(requireContext(), balanceMoney)
            pocketViewModel.insertNotePocket(requireContext(), balanceGopay)
            pocketViewModel.insertNotePocket(requireContext(), balanceOvo)
            Toast.makeText(requireContext(), "Success Input Your Balance", Toast.LENGTH_LONG).show()
            startActivity(Intent(requireContext(), MainActivity::class.java))
            (requireContext() as Activity).finish()
        }
    }
}
