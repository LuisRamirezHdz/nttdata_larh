package com.example.helloworld.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworld.data.model.PersonModel
import com.example.helloworld.domain.GetDataUseCase
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel : ViewModel (){
    val person = MutableLiveData<PersonModel>()

    var getDataUseCase = GetDataUseCase()

    fun getData()  {
        viewModelScope.launch {
            try {
                val response = getDataUseCase()
                person.postValue(response.results?.get(0))

            } catch (e: IOException) {
                person.postValue(null)
            }
        }
    }
}