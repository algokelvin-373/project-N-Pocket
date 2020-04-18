package com.algokelvin.n_pocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.algokelvin.utils.db.entity.PocketEntity
import com.algokelvin.utils.recyclerview.setupAdapterData
import com.algokelvin.utils.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.fragment_money.*
import kotlinx.android.synthetic.main.item_data_pocket.view.*
import java.util.ArrayList

@Suppress("DEPRECATION")
class MoneyFragment : Fragment() {
    private val pocketViewModel by lazy {
        ViewModelProviders.of(this).get(PocketViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listPocketMoney = pocketViewModel.getNotePocket(requireContext()) as ArrayList<PocketEntity>
        rvItemPocketMoney.setupAdapterData(R.layout.item_data_pocket, requireContext(), listPocketMoney) {
            data {
                viewItem.descriptionPocket.text = item?.description
                viewItem.amountPocket.text = item?.amount.toString()
            }
            setLayoutManager(linearLayoutManager(), 0)
            setAdapter()
        }
    }

}
