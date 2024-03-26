package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.dto.Post
import com.example.myapplication.data.remote.webservice.WebService
import com.example.myapplication.domain.repository.DataRepo
import com.example.myapplication.util.ErrorType
import com.example.myapplication.util.Resource
import java.net.SocketTimeoutException
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val webService: WebService
) : DataRepo {
    override suspend fun getPosts(): Resource<List<Post>> {
        try {
            val task = webService.getPosts()
            if (task.isSuccessful) {
                task.body()?.let {
                    return Resource.Success(data = it )
                } ?: return Resource.Error(errorType = ErrorType.EMPTY_DATA)
            } else {
                return Resource.Error()
            }
        } catch (e: SocketTimeoutException) {
            return Resource.Error(errorType = ErrorType.TIME_OUT)
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage)
        }
    }
}
