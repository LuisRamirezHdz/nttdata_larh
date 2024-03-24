package com.example.helloworld.data

import com.example.helloworld.data.model.GetDataResponse
import com.example.helloworld.data.network.GetDataService

class GetDataRepository {
    private val api = GetDataService()

    suspend fun getData(): GetDataResponse {

        return api.getData()

    }
}