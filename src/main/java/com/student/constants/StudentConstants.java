package com.student.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudentConstants {

    STUDENT_ID_PREFIX("STDID", ""),
    ID_PREFIX("0", "00");

    private final String code;
    private final String description;
}
