package com.example.praktikum4_navcompose.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praktikum4_navcompose.data.repository.StudentRepository

class HomeViewModel(private val repository: StudentRepository) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set

    fun loadStudents() {
        uiState = HomeUiState(isLoading = true)

        val students = repository.getStudents()
        uiState = if (students.isNotEmpty()) {
            HomeUiState(students = students)
        } else {
            HomeUiState(errorMessage = "Student tidak ditemukan")
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}
