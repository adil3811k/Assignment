package com.example.assignment.di

import android.content.Context
import com.example.assignment.dataLayer.datasource.ApiService
import com.example.assignment.dataLayer.repocitory.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.annotation.Signed


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Signed
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://52.25.229.242:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun ProvideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    fun provideRepository(apiService: ApiService) : RemoteRepository{
        return RemoteRepository(apiService)
    }
}