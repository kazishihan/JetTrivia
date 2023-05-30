
package com.shihan.jettrivia.network

import com.shihan.jettrivia.model.Question
import retrofit2.http.GET

interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestion():Question
}