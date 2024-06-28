// Generated by Dagger (https://dagger.dev).
package com.example.todolist.di;

import android.content.Context;
import com.example.data.local.ToDoDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideDatabaseFactory implements Factory<ToDoDatabase> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ToDoDatabase get() {
    return provideDatabase(contextProvider.get());
  }

  public static AppModule_ProvideDatabaseFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideDatabaseFactory(contextProvider);
  }

  public static ToDoDatabase provideDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDatabase(context));
  }
}
