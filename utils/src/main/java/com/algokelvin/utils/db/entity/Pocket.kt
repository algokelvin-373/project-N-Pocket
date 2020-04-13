package com.algokelvin.utils.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pocket(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pocket")
    var id: Int = 0,

    @ColumnInfo(name = "date_pocket")
    var date: String? = null,

    @ColumnInfo(name = "amount_pocket")
    var amount: Int? = null,

    @ColumnInfo(name = "description_pocket")
    var description: String? = null
)