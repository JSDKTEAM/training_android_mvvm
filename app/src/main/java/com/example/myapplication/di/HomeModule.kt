package com.example.myapplication.di

import com.example.myapplication.data.api.ApiTestInterface
import com.example.myapplication.domain.usecase.home.LoadUsersUseCase
import com.example.myapplication.domain.usecase.home.LoadUsersUseCaseImpl
import com.example.myapplication.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    factory<LoadUsersUseCase> {
        LoadUsersUseCaseImpl(
            remoteDataSource = get<ApiTestInterface>()
        )
    }

    viewModel {
        HomeViewModel()
    }
}