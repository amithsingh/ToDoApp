package com.example.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/data/repository/TodoRepositoryImpl;", "Lcom/example/domain/repo/TodoRepository;", "todoDao", "Lcom/example/data/local/ToDoDAO;", "(Lcom/example/data/local/ToDoDAO;)V", "addToDo", "", "todo", "Lcom/example/domain/model/Todo;", "(Lcom/example/domain/model/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToDoList", "Lkotlinx/coroutines/flow/Flow;", "", "data_debug"})
public final class TodoRepositoryImpl implements com.example.domain.repo.TodoRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.local.ToDoDAO todoDao = null;
    
    @javax.inject.Inject
    public TodoRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.data.local.ToDoDAO todoDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.domain.model.Todo>> getToDoList() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addToDo(@org.jetbrains.annotations.NotNull
    com.example.domain.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}