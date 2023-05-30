package com.shihan.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.shihan.jettrivia.component.Questions

@Composable
fun TriviaHome(viewModel:QuestionViewModel= hiltViewModel()){
    Questions(viewModel = viewModel)
}