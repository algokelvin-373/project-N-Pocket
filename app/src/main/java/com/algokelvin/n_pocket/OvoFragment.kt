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
class OvoFragment : Fragment() {
    private val pocketViewModel by lazy {
        ViewModelProviders.of(this).get(PocketViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleNoteMoney.text = getString(R.string.note_ovo)

        val listPocketOvo = pocketViewModel.getNotePocket(requireContext(), "ovo") as ArrayList<PocketEntity>
        rvItemPocketMoney.setupAdapterData(R.layout.item_data_pocket, requireContext(), listPocketOvo) {
            data {
                viewItem.descriptionPocket.text = item?.description
                viewItem.amountPocket.text = item?.amount.toString()
            }
            setLayoutManager(linearLayoutManager(), 0)
            setAdapter()
        }
    }

}
