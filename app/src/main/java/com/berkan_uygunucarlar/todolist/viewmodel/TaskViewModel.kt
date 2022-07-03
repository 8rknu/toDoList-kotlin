package com.berkan_uygunucarlar.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.berkan_uygunucarlar.todolist.database.TaskDao
import com.berkan_uygunucarlar.todolist.database.TaskDatabase
import com.berkan_uygunucarlar.todolist.database.TaskEntry
import com.berkan_uygunucarlar.todolist.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskDao = TaskDatabase.gatDatabase(application).taskDao()
    private val repository : TaskRepository = TaskRepository(taskDao)

    val getAllTasks : LiveData<List<TaskEntry>> = repository.getAllTasks()

    fun insert(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(taskEntry)
        }
    }

    fun delete(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(taskEntry)
        }
    }

    fun update(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateData(taskEntry)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }

}