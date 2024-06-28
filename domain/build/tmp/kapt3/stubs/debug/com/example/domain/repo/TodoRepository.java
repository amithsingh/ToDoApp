package com.example.domain.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/domain/repo/TodoRepository;", "", "addToDo", "", "todo", "Lcom/example/domain/model/Todo;", "(Lcom/example/domain/model/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToDoList", "Lkotlinx/coroutines/flow/Flow;", "", "domain_debug"})
public abstract interface TodoRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.domain.model.Todo>> getToDoList();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addToDo(@org.jetbrains.annotations.NotNull
    com.example.domain.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}