package com.example.data

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data.local.ToDoEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*Unit test case for Room Database to check the data is inserted and get operations*/
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {
    private lateinit var toDoDatabase: com.example.data.local.ToDoDatabase
    private lateinit var toDoDao: com.example.data.local.ToDoDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        toDoDatabase = Room.inMemoryDatabaseBuilder(context, com.example.data.local.ToDoDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        toDoDao = toDoDatabase.toDoDao()
    }

    @After
    fun teardown() {
        toDoDatabase.close()
    }

    @Test
    fun insertAndGetTasks() = runTest {
        // Given
        val task1 = ToDoEntity(1, "Task 1")
        val task2 = ToDoEntity(2, "Task 2")

        // When
        toDoDao.addToDo(task1)
        toDoDao.addToDo(task2)

        // Then
        val tasks = toDoDao.getToDoList().first()

        assertThat(tasks.size).isEqualTo(2)
        assertThat(tasks).contains(task1)
        assertThat(tasks).contains(task2)
    }

}