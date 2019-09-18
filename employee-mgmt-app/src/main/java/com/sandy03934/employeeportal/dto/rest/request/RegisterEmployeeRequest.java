package com.sandy03934.employeeportal.dto.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEmployeeRequest {
    private String firstName;

    private String lastName;

    private Date dob;

    private String gender;

    private String department;
}
