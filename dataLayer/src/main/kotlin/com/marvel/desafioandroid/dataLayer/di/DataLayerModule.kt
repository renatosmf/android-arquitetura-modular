package com.marvel.desafioandroid.dataLayer.di

import com.marvel.desafioandroid.dataLayer.data.remote.HttpClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import java.util.*

object DataLayerModule {
    private val modules = module {
        factory { HttpClient(androidApplication()) }
        factory {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(Date::class.java, Rfc3339DateJsonAdapter())
                .build()
        }
    }

    fun loadModules() {
        loadKoinModules(modules)
    }
}
