package com.example.helloworld.domain

import com.example.helloworld.data.GetDataRepository
import com.example.helloworld.data.model.GetDataResponse

class GetDataUseCase {
    private val getDataRepository = GetDataRepository()

    suspend operator fun invoke(): GetDataResponse = getDataRepository.getData()
}