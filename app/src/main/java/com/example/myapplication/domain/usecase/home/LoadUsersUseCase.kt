package com.example.myapplication.domain.usecase.home

import com.example.myapplication.data.api.ApiTestInterface
import com.example.myapplication.data.entities.UseCaseResult
import com.example.myapplication.data.entities.User

interface LoadUsersUseCase {
    suspend fun execute() : UseCaseResult<User>
}

class LoadUsersUseCaseImpl (
    private val remoteDataSource : ApiTestInterface
) : LoadUsersUseCase {
    override suspend fun execute(): UseCaseResult<User> {
        return try{
            val result = remoteDataSource.getUsers()
            UseCaseResult.Success(result)
        }catch (ex : Exception){
            UseCaseResult.Error(ex)
        }
    }

}