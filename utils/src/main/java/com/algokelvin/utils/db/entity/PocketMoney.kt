package com.algokelvin.utils.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PocketMoney(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_money")
    var id: Int = 0,

    @ColumnInfo(name = "amount_money")
    var amount: Int? = null,

    @ColumnInfo(name = "description_money")
    var description: String? = null
)