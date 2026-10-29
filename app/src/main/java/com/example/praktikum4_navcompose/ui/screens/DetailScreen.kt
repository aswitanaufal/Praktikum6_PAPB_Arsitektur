package com.example.praktikum4_navcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum4_navcompose.ui.detail.DetailUiState

@Composable
fun DetailScreen(
//    studentId: Int,
    uiState: DetailUiState,
    onBack: () -> Unit,
//    onOpenProfile: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Detail Student", style = MaterialTheme.typography.headlineMedium)
        when{
            uiState.errorMsg != null ->
                Text(uiState.errorMsg)
            uiState.student != null -> {
                val student = uiState.student
                Text("ID: ${student.id}")
                Text("Nama: ${student.name}")
                Text("Program: ${student.program}")
                Text("Angkatan: ${student.year}")
            }
        }
        Button(onClick = onBack) {
            Text("Kembali")
        }
//        }
//        Text("Student ID: $studentId")
//        Button(onClick = onBack) { Text("Kembali") }
//        Button(onClick = onOpenProfile){Text("Buka Profile")}
    }
}