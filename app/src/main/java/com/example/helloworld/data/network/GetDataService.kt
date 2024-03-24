package com.example.helloworld.data.network

import com.example.helloworld.core.RetrofitHelper
import com.example.helloworld.data.model.GetDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetDataService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getData(): GetDataResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(GetDataApiClient::class.java).getData()

            response.body()!!
        }
    }
}