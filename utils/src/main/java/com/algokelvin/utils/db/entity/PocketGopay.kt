package com.algokelvin.utils.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PocketGopay(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_gopay")
    var id: Int = 0,

    @ColumnInfo(name = "amount_gopay")
    var amount: Int? = null,

    @ColumnInfo(name = "description_gopay")
    var description: String? = null
)