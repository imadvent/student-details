package com.student.controller;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Students", description = "the Students List")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(
            summary = "Insert students data",
            description = "insert all students data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping(value = "/insert", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody StudentRequest studentRequest) {

        StudentResponse studentResponse = studentService.insert(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "Fetch all students",
            description = "fetches all students data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(value = "/viewall", produces = "application/json")
    public ResponseEntity<?> readAll() {

        List<StudentResponse> studentResponse = studentService.viewAll();
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "Fetch students",
            description = "fetches students data by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(value = "/view/{studentId}", produces = "application/json")
    public ResponseEntity<?> read(@PathVariable("studentId") int studentId) {

        StudentResponse studentResponse = studentService.view(studentId);

        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "update students",
            description = "update students data by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping(value = "/change/{studentId}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("studentId") int studentId,
                                    @RequestBody StudentRequest studentRequest) {

        StudentResponse studentResponse = studentService.change(studentId, studentRequest);

        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "delete students",
            description = "delete students data by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping(value = "/remove/{studentId}")
    public ResponseEntity<?> delete(@PathVariable("studentId") int studentId) {

        studentService.remove(studentId);

        return new ResponseEntity<>("data deleted successfully", HttpStatus.OK);
    }
}
