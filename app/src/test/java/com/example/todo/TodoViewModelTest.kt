package com.example.todo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import chat.uob.com.chatbot.utils.getValue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.koin.test.inject

class TodoViewModelTest: BaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val todoViewModel: TodoViewModel by inject()

    @Test
    fun shouldAddATodoWithGivenDescription() {

        with(todoViewModel) {

            val description = "todo 1"
            addTodo(description)

            assertEquals(todoRepository.todos.size, 1)
            assertEquals(todoRepository.todos[0].status, TodoStatus.OPEN)
            assertEquals(todoRepository.todos[0].description, description)

            assertNotNull(getValue(todos))
        }
    }

}