package org.example.service;

import org.example.domain.student.Student;

public interface StudentService {
    Student getStudentInfo(long id);

    void createStudent(Student student);
}
