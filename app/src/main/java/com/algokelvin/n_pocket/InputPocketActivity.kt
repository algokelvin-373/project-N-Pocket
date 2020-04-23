package com.algokelvin.n_pocket

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.algokelvin.utils.db.entity.PocketEntity
import com.algokelvin.utils.getDateConvert
import com.algokelvin.utils.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.activity_input_pocket.*
import java.util.*


class InputPocketActivity : AppCompatActivity() {
    private var date = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_pocket)

        val pocketViewModel = ViewModelProvider(this)[PocketViewModel::class.java]
        val typePocket = intent.getStringExtra("type_pocket_data") ?: "money"
        val title = getString(R.string.input_note_pocket, typePocket.substring(0, 1).toUpperCase(Locale.getDefault())+typePocket.substring(1))

        titleInput.text = title
        val idCode = when(typePocket) {
            "money" -> "11"
            "gopay" -> "22"
            "ovo" -> "33"
            else -> "00"
        }

        var d = "0"; var m = "0"; var y = "0"
        data_date.setOnClickListener {
            val calender = Calendar.getInstance()
            val day: Int = calender.get(Calendar.DAY_OF_MONTH)
            val month: Int = calender.get(Calendar.MONTH)
            val year: Int = calender.get(Calendar.YEAR)
            val picker = DatePickerDialog(this, OnDateSetListener { _, yearPicker, monthOfYear, dayOfMonth ->
                y = yearPicker.toString()
                m = when((monthOfYear + 1) < 10) {
                    true -> "0"+(monthOfYear + 1)
                    else -> (monthOfYear + 1).toString()
                }
                d = dayOfMonth.toString()
                date = getDateConvert("yyyy.MM.dd", "$y.$m.$d", "d MMM yyyy")
            }, year, month, day)
            picker.show()
        }

        btn_submit.setOnClickListener {
            val pocketEntity = PocketEntity((idCode+d+m+y+(0..100).random()).toLong(), date,
                data_amount.text.toString().toInt(), data_description.text.toString(), typePocket)
            pocketViewModel.insertNotePocket(this, pocketEntity)
            Toast.makeText(this, "Success input note pocket money", Toast.LENGTH_LONG).show()
        }
    }
}
