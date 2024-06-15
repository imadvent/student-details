package com.student.service.impl;

import com.student.dao.StudentDao;
import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.student.util.StudentUtil.*;
import static java.time.LocalDateTime.now;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentResponse insert(StudentRequest studentRequest) {

        StudentResponse studentResponse = new StudentResponse();
        Student student = new Student();

        requestMapper(studentRequest, student);
        student.setStudentEnrollmentDate(dateToStringFormat(now()));
        student.setUpdatedStudentEnrollmentDate("-");
        studentDao.save(student);

        responseMapper(student, studentResponse);

        return studentResponse;
    }

    @Override
    public StudentResponse view(int studentId) {

        StudentResponse studentResponse = new StudentResponse();
        Optional<Student> getStudent = studentDao.findById(studentId);

        if (getStudent.isPresent()) {

            Student student = getStudent.get();

            responseMapper(student, studentResponse);
        }
        return studentResponse;
    }

    @Override
    public List<StudentResponse> viewAll() {

        List<StudentResponse> studentList = new ArrayList<>();
        List<Student> students = studentDao.findAll();

        students.forEach(student -> {
            StudentResponse studentResponse = new StudentResponse();
            responseMapper(student, studentResponse);

            studentList.add(studentResponse);
        });

        return studentList;
    }

    @Override
    public StudentResponse change(int studentId, StudentRequest studentRequest) {

        StudentResponse studentResponse = new StudentResponse();
        Optional<Student> getStudent = studentDao.findById(studentId);

        if (getStudent.isPresent()) {
            Student student = getStudent.get();

            requestMapper(studentRequest, student);
            student.setUpdatedStudentEnrollmentDate(dateToStringFormat(now()));
            studentDao.save(student);
            responseMapper(student, studentResponse);
        }

        return studentResponse;
    }

    @Override
    public void remove(int studentId) {

        Optional<Student> getStudent = studentDao.findById(studentId);

        if (getStudent.isPresent()) {
            studentDao.deleteById(studentId);
        }
    }
}
