// Generated by Dagger (https://dagger.dev).
package com.example.todolist.presentation.viewmodel;

import com.example.domain.usecase.TodoUseCases;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ToDoViewModel_Factory implements Factory<ToDoViewModel> {
  private final Provider<TodoUseCases> todoUseCasesProvider;

  public ToDoViewModel_Factory(Provider<TodoUseCases> todoUseCasesProvider) {
    this.todoUseCasesProvider = todoUseCasesProvider;
  }

  @Override
  public ToDoViewModel get() {
    return newInstance(todoUseCasesProvider.get());
  }

  public static ToDoViewModel_Factory create(Provider<TodoUseCases> todoUseCasesProvider) {
    return new ToDoViewModel_Factory(todoUseCasesProvider);
  }

  public static ToDoViewModel newInstance(TodoUseCases todoUseCases) {
    return new ToDoViewModel(todoUseCases);
  }
}
