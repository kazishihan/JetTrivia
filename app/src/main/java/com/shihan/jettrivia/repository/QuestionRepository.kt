package com.shihan.jettrivia.repository

import android.util.Log
import com.shihan.jettrivia.data.DataOrException
import com.shihan.jettrivia.model.QuestionItem
import com.shihan.jettrivia.network.QuestionApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject



class QuestionRepository @Inject constructor(val questionApi: QuestionApi) {
    
    private val questionDataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()
    
    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
    
        try {
            questionDataOrException.loading=true
            questionDataOrException.data=questionApi.getAllQuestion()
            if (questionDataOrException.data.toString().isNotEmpty()) questionDataOrException.loading=false
        }catch (e:Exception){
            questionDataOrException.e=e
            Log.d("Exc", "getAllQuestions: ${questionDataOrException.e!!.localizedMessage}")
        }
        
        return questionDataOrException
    }
}