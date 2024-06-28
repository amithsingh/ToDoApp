// Generated by Dagger (https://dagger.dev).
package com.example.todolist.di;

import com.example.data.local.ToDoDAO;
import com.example.domain.repo.TodoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideRepositoryFactory implements Factory<TodoRepository> {
  private final Provider<ToDoDAO> toDoDaoProvider;

  public AppModule_ProvideRepositoryFactory(Provider<ToDoDAO> toDoDaoProvider) {
    this.toDoDaoProvider = toDoDaoProvider;
  }

  @Override
  public TodoRepository get() {
    return provideRepository(toDoDaoProvider.get());
  }

  public static AppModule_ProvideRepositoryFactory create(Provider<ToDoDAO> toDoDaoProvider) {
    return new AppModule_ProvideRepositoryFactory(toDoDaoProvider);
  }

  public static TodoRepository provideRepository(ToDoDAO toDoDao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRepository(toDoDao));
  }
}