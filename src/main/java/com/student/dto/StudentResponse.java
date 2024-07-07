package com.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private String studentId;
    private String studentName;
    private String studentAddress;
    private String studentEnrollmentDate;
    private String updatedStudentEnrollmentDate;
}
