package com.example.todo

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TodoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = TodoAdapter(emptyList()) { todo: Todo, isChecked: Boolean ->
            statusChangedFor(todo, isChecked)
        }

        findViewById<RecyclerView>(R.id.todosRecyclerView).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewModel.todos.observe(this, Observer {
            viewAdapter.todos = it!!
        })
    }

    private fun statusChangedFor(todo: Todo, isCompleted: Boolean) {
        Log.i("Status changed>>>>>>", todo.toString())
        // view model should update the todo with new status
    }

    fun addTodo(view: View) {

        val newTodoDescription = findViewById<TextInputEditText>(R.id.newTodoDescription).text
        Log.i("Add Todo>>>>>>", newTodoDescription.toString())
        // add the new todo to the repo via view model
        viewModel.addTodo(newTodoDescription.toString())
    }

}
