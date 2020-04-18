package com.algokelvin.n_pocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_input_pocket.*

class InputPocketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_pocket)

        val typePocket = intent.getStringExtra("type_pocket_data")
        titleInput.text = typePocket
    }
}
