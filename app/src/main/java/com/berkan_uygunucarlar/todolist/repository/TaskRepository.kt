package com.berkan_uygunucarlar.todolist.repository

import androidx.lifecycle.LiveData
import com.berkan_uygunucarlar.todolist.database.TaskDao
import com.berkan_uygunucarlar.todolist.database.TaskEntry

class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun updateData(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    suspend fun deleteItem(taskEntry: TaskEntry) = taskDao.delete(taskEntry)

    suspend fun deleteAll(){
        taskDao.deleteAll()
    }

    fun getAllTasks() : LiveData<List<TaskEntry>> = taskDao.getAllTasks()

    fun getAllPriorityTasks() : LiveData<List<TaskEntry>> = taskDao.getAllPriorityTasks()

    fun searchDatabase(searchQuery: String) : LiveData<List<TaskEntry>>{
        return taskDao.searchDatabase(searchQuery)
    }
}