package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/*DAO class used for Room database for performing operations*/
@Dao
interface ToDoDAO {
    @Query("SELECT * FROM ToDo")
    fun getToDoList(): Flow<List<ToDoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToDo(task: ToDoEntity)

}