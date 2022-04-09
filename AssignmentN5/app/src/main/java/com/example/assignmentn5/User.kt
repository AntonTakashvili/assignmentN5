package com.example.assignmentn5

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "runDistance")
    val runningDistance:Int,
    @ColumnInfo(name = "swimDistance")
    val swimmingDistance:Int,
    @ColumnInfo(name = "calories")
    val calories:Double
)