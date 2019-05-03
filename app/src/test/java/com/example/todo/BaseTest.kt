package com.example.todo

import android.app.Application
import com.example.todo.di.appModule
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.mockito.Mockito

abstract class BaseTest: AutoCloseKoinTest() {

    @Before
    open fun setup() {
        startKoin {
            androidContext(Mockito.mock(Application::class.java))
            modules(appModule)
        }
    }
}