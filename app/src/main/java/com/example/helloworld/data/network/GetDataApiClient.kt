package com.example.helloworld.data.network

import com.example.helloworld.data.model.GetDataResponse
import retrofit2.Response
import retrofit2.http.*

interface GetDataApiClient {
    @Headers(
        "Content-Type: application/json",
    )
    @GET("api")
    suspend fun getData(): Response<GetDataResponse>
}