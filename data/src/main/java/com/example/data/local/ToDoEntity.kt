package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Todo

/*Entity class for Room Database used to table name and columns in table*/
@Entity(tableName = "ToDo")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String
) {
    fun toDomain(): Todo {
        return Todo(
            id = id,
            title = title
        )
    }

    companion object {
        fun fromDomain(todo: Todo): ToDoEntity {
            return ToDoEntity(
                id = todo.id,
                title = todo.title
            )
        }
    }
}
