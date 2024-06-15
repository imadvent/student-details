package com.student.service;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse insert(StudentRequest studentRequest);

    StudentResponse view(int studentId);

    List<StudentResponse> viewAll();

    StudentResponse change(int studentId, StudentRequest studentRequest);

    void remove(int studentId);
}
