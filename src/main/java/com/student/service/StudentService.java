package com.student.service;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse insert(StudentRequest studentRequest);

    StudentResponse view(String studentId);

    List<StudentResponse> viewAll();

    StudentResponse change(String studentId, StudentRequest studentRequest);

    void remove(String studentId);

    String generateShoppingId();
}
