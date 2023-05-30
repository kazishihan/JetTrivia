package com.shihan.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shihan.jettrivia.data.DataOrException
import com.shihan.jettrivia.model.QuestionItem
import com.shihan.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private  val questionRepo:QuestionRepository):ViewModel(){
    
    val data : MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>>
    = mutableStateOf(DataOrException(null,true,Exception("")))
    
    init {
        getAllQuestion()
    }
    
    private fun getAllQuestion(){
        viewModelScope.launch {
            data.value.loading=true
            data.value= questionRepo.getAllQuestions()
            if(data.value.data.toString().isNotEmpty()){
                data.value.loading=false
            }
        }
    }
    
}