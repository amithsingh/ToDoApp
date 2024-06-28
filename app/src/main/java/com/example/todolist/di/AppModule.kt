package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.ToDoDatabase
import com.example.data.local.ToDoDAO
import com.example.data.repository.TodoRepositoryImpl
import com.example.domain.repo.TodoRepository
import com.example.domain.usecase.AddTodoUseCase
import com.example.domain.usecase.GetTodosUseCase
import com.example.domain.usecase.TodoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*Module class is used to provide the dependencies of the request class through Dagger Hilt*/
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /*Function is used to provide Room Database initialization */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ToDoDatabase::class.java,
            "todo_database"
        ).build()
    }

    /*Function is used to provide dependency of DAO class*/
    @Provides
    fun provideToDoDao(database: ToDoDatabase) = database.toDoDao()

    /*Function is used to provide dependency of repository*/
    @Provides
    @Singleton
    fun provideRepository(toDoDao: ToDoDAO): TodoRepository {
        return TodoRepositoryImpl(toDoDao)
    }

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoRepository): TodoUseCases {
        return TodoUseCases(
            getTodosUseCase = GetTodosUseCase(repository),
            addTodoUseCase = AddTodoUseCase(repository)
        )
    }

}