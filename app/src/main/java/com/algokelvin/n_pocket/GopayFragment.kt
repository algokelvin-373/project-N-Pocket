package com.algokelvin.n_pocket

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.algokelvin.utils.db.entity.PocketEntity
import com.algokelvin.utils.getDate
import com.algokelvin.utils.getDateConvert
import com.algokelvin.utils.recyclerview.setupAdapterData
import com.algokelvin.utils.rupiahFormat
import com.algokelvin.utils.setNegativePrice
import com.algokelvin.utils.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.fragment_money.*
import kotlinx.android.synthetic.main.item_data_pocket.view.*
import java.util.*

class GopayFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pocketViewModel = ViewModelProvider(requireActivity())[PocketViewModel::class.java]
        titleNoteMoney.text = getString(R.string.note_gopay)
        amount_balance_money.text = getString(R.string.balance, rupiahFormat(pocketViewModel.getAmountPocket(requireContext(), "gopay").toString()))
        dateMoney.text = getDate("d MMM yyyy")
        dateMoney.setOnClickListener {
            val calender = Calendar.getInstance()
            val day: Int = calender.get(Calendar.DAY_OF_MONTH)
            val month: Int = calender.get(Calendar.MONTH)
            val year: Int = calender.get(Calendar.YEAR)
            val picker = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener { _, y, m, d ->
                    val month = when ((m + 1) < 10) {
                        true -> "0" + (m + 1)
                        else -> (m + 1).toString()
                    }
                    dateMoney.text = getDateConvert("yyyy.MM.dd", "$y.$month.$d", "d MMM yyyy")
                    val listPocketGopay = pocketViewModel.getNotePocket(requireContext(), "gopay", dateMoney.text.toString()) as ArrayList<PocketEntity>
                    setItemPocketGOPAY(listPocketGopay)
                }, year, month, day)
            picker.show()
        }

        val listPocketGopay = pocketViewModel.getNotePocket(requireContext(), "gopay", dateMoney.text.toString()) as ArrayList<PocketEntity>
        setItemPocketGOPAY(listPocketGopay)
    }
    private fun setItemPocketGOPAY(listPocketMoney: ArrayList<PocketEntity>) {
        rvItemPocketMoney.setupAdapterData(R.layout.item_data_pocket, requireContext(), listPocketMoney) {
            data {
                viewItem.descriptionPocket.text = getString(R.string._160_data_description, item?.description)
                viewItem.amountPocket.text = setNegativePrice(item?.amount!!)
            }
            setLayoutManager(linearLayoutManager(), 0)
            setAdapter()
        }
    }

}
