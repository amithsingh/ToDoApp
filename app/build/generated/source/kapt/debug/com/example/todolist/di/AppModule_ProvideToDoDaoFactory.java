// Generated by Dagger (https://dagger.dev).
package com.example.todolist.di;

import com.example.data.local.ToDoDAO;
import com.example.data.local.ToDoDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideToDoDaoFactory implements Factory<ToDoDAO> {
  private final Provider<ToDoDatabase> databaseProvider;

  public AppModule_ProvideToDoDaoFactory(Provider<ToDoDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ToDoDAO get() {
    return provideToDoDao(databaseProvider.get());
  }

  public static AppModule_ProvideToDoDaoFactory create(Provider<ToDoDatabase> databaseProvider) {
    return new AppModule_ProvideToDoDaoFactory(databaseProvider);
  }

  public static ToDoDAO provideToDoDao(ToDoDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideToDoDao(database));
  }
}
