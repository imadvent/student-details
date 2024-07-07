package com.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id
    private String studentId;
    private String studentName;
    private String studentAddress;
    private String studentEnrollmentDate;
    private String updatedStudentEnrollmentDate;

}
