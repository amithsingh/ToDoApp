package com.example.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/data/local/ToDoDAO;", "", "addToDo", "", "task", "Lcom/example/data/local/ToDoEntity;", "(Lcom/example/data/local/ToDoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToDoList", "Lkotlinx/coroutines/flow/Flow;", "", "data_debug"})
@androidx.room.Dao
public abstract interface ToDoDAO {
    
    @androidx.room.Query(value = "SELECT * FROM ToDo")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.local.ToDoEntity>> getToDoList();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addToDo(@org.jetbrains.annotations.NotNull
    com.example.data.local.ToDoEntity task, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}