package com.algokelvin.utils.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PocketOvo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ovo")
    var id: Int = 0,

    @ColumnInfo(name = "amount_ovo")
    var amount: Int? = null,

    @ColumnInfo(name = "description_ovo")
    var description: String? = null
)