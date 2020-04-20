package com.algokelvin.n_pocket

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_pocket.*
import java.util.*


class InputPocketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_pocket)

        val typePocket = intent.getStringExtra("type_pocket_data") ?: "money"
        val title = getString(R.string.input_note_pocket, typePocket.substring(0, 1).toUpperCase(Locale.getDefault())+typePocket.substring(1))

        titleInput.text = title

        data_date.setOnClickListener {
            val calender = Calendar.getInstance()
            val day: Int = calender.get(Calendar.DAY_OF_MONTH)
            val month: Int = calender.get(Calendar.MONTH)
            val year: Int = calender.get(Calendar.YEAR)
            val picker = DatePickerDialog(this, OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                data_date.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
            }, year, month, day)
            picker.show()
        }
    }
}
