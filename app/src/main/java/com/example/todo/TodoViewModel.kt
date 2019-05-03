package com.example.todo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.time.LocalDateTime

class TodoViewModel(val todoRepository: TodoRepository) : ViewModel() {

    val todos = MutableLiveData<List<Todo>>()

    fun addTodo(description: String) {
        todoRepository.add(Todo(System.currentTimeMillis(), description, LocalDateTime.now(), TodoStatus.OPEN))
        todos.value = todoRepository.todos
    }

}