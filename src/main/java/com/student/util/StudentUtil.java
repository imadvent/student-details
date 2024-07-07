package com.student.util;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.student.constants.StudentConstants.ID_PREFIX;

public class StudentUtil {

    public static String dateToStringFormat(LocalDateTime localDateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return formatter.format(localDateTime);
    }

    public static void requestMapper(StudentRequest studentRequest, Student student) {
        student.setStudentName(studentRequest.getStudentName());
        student.setStudentAddress(studentRequest.getStudentAddress());

    }

    public static void responseMapper(Student student, StudentResponse studentResponse) {

        studentResponse.setStudentId(student.getStudentId());
        studentResponse.setStudentName(student.getStudentName());
        studentResponse.setStudentAddress(student.getStudentAddress());
        studentResponse.setStudentEnrollmentDate(student.getStudentEnrollmentDate());
        studentResponse.setUpdatedStudentEnrollmentDate(student.getUpdatedStudentEnrollmentDate());
    }

    public static String prefixAppend(StringBuilder id, int count) {
        if (String.valueOf(count).length() == 1) {
            id.append(ID_PREFIX.getDescription()).append(count);
        } else if (String.valueOf(count).length() == 2) {
            id.append(ID_PREFIX.getCode()).append(count);
        } else {
            id.append(count);
        }
        return id.toString();
    }
}
