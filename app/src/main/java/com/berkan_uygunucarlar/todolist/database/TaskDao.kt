package com.berkan_uygunucarlar.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(taskEntry: TaskEntry)

    @Update
    suspend fun update(taskEntry: TaskEntry)

    @Delete
    suspend fun delete(taskEntry: TaskEntry)

    @Query("DELETE FROM taskTable")
    suspend fun deleteAll()

    @Query("SELECT * FROM taskTable ORDER BY timestamp DESC")
    fun getAllTasks() : LiveData<List<TaskEntry>>

}