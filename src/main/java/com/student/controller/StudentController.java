package com.student.controller;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/insert")
    public ResponseEntity<?> create(@RequestBody StudentRequest studentRequest) {

        StudentResponse studentResponse = studentService.insert(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/viewall")
    public ResponseEntity<?> readAll() {

        List<StudentResponse> studentResponse = studentService.viewAll();
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/view/{studentId}")
    public ResponseEntity<?> read(@PathVariable("studentId") int studentId) {

        StudentResponse studentResponse = studentService.view(studentId);

        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/change/{studentId}")
    public ResponseEntity<?> update(@PathVariable("studentId") int studentId, @RequestBody StudentRequest studentRequest) {

        StudentResponse studentResponse = studentService.change(studentId, studentRequest);

        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{studentId}")
    public ResponseEntity<?> delete(@PathVariable("studentId") int studentId) {

        studentService.remove(studentId);

        return new ResponseEntity<>("data deleted successfully", HttpStatus.OK);
    }
}
