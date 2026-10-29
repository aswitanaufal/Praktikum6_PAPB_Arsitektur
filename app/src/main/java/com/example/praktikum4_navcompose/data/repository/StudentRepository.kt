package com.example.praktikum4_navcompose.data.repository

import com.example.praktikum4_navcompose.data.model.Student
import com.example.praktikum4_navcompose.data.source.StudentLocalDataSource
// formating data dilakukan di sini
interface StudentRepository { //ibarat sebuah kontrak
    fun getStudents(): List<Student>
    fun getStudentById(id: Int): Student?
}

// harus override interface
// ketika panggil repository, maka fungsi ini yg akan digunakan
class DefaultStudentRepository(
    private val dataSource: StudentLocalDataSource //implement interface
): StudentRepository {
    override fun getStudents(): List<Student> {
        return dataSource.getStudents()
    }

    override fun getStudentById(id: Int): Student? {
        return dataSource.getStudentById(id)
    }
}
