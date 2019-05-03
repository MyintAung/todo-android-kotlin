package com.example.todo.di

import com.example.todo.TodoRepository
import com.example.todo.TodoViewModel
import org.koin.android.viewmodel.dsl.viewModel

import org.koin.dsl.module

val appModule = module {

    single { TodoRepository() }
    viewModel { TodoViewModel(get()) }
}