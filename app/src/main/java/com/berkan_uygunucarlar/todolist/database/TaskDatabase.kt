package com.berkan_uygunucarlar.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(TaskEntry::class), version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object{
        @Volatile

        private var INSTANCE : TaskDatabase? = null
        fun gatDatabase(context: Context) : TaskDatabase{
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "taskDatabase"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
            }
            return instance
        }



    }

}