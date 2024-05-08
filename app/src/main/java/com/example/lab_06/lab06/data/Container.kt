package com.example.lab_06.lab06.data

import android.app.Application
import android.content.Context
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab_06.lab06.Priority
import com.example.lab_06.lab06.data.entities.AppDatabase
import com.example.lab_06.lab06.data.entities.DatabaseTodoTaskRepository
import com.example.lab_06.lab06.data.entities.TodoTaskRepository
import java.time.LocalDate

interface AppContainer {
    val todoTaskRepository: TodoTaskRepository
}

class AppDataContainer(private val context: Context): AppContainer{
    override val todoTaskRepository: TodoTaskRepository by lazy{
        DatabaseTodoTaskRepository(AppDatabase.getInstance(context).taskDao())
    }
}

class TodoApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this.applicationContext)
    }

}