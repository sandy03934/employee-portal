package com.sandy03934.employeeportal.dto.rest.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeDetails {

    private String publicId;

    private String firstName;

    private String lastName;

    private Integer age;

    private String gender;

    private String department;
}
