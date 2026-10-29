package com.example.praktikum4_navcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum4_navcompose.data.model.Student
import com.example.praktikum4_navcompose.ui.home.HomeUiState

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    HomeScreenContent(
        students = uiState.students,
        isLoading = uiState.isLoading,
        errorMessage = uiState.errorMessage,
        onOpenDetail = onOpenDetail,
        onOpenProfile = onOpenProfile,
        onOpenAbout = onOpenAbout
    )
}

@Composable
fun HomeScreen(
    students: List<Student>,
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    HomeScreenContent(
        students = students,
        isLoading = false,
        errorMessage = null,
        onOpenDetail = onOpenDetail,
        onOpenProfile = onOpenProfile,
        onOpenAbout = onOpenAbout
    )
}

@Composable
private fun HomeScreenContent(
    students: List<Student>,
    isLoading: Boolean,
    errorMessage: String?,
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Home", style = MaterialTheme.typography.headlineMedium)

        when {
            isLoading -> {
                Text("Loading data student")
            }
            errorMessage != null -> {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = errorMessage,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            students.isEmpty() -> {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Data mahasiswa tidak ditemukan.",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(students) { student ->
                        Card(
                            onClick = { onOpenDetail(student.id) },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text("ID: ${student.id}", style = MaterialTheme.typography.bodyMedium)
                                Text(student.name, style = MaterialTheme.typography.titleMedium)
                            }
                        }
                    }
                }
            }
        }

        OutlinedButton(onClick = onOpenProfile) {
            Text("Buka Profile")
        }
        OutlinedButton(onClick = onOpenAbout) {
            Text("Buka About")
        }
    }
}
