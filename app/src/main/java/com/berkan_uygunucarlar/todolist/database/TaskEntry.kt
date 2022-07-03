package com.berkan_uygunucarlar.todolist.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "taskTable")
data class TaskEntry(
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    var title : String,
    var priority : Int,
    var timestamp : Long
): Parcelable