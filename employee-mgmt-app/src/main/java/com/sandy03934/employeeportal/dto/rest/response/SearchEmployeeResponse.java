package com.sandy03934.employeeportal.dto.rest.response;

import lombok.Data;
import org.springframework.data.domain.PageImpl;

@Data
public class SearchEmployeeResponse implements Response {

    RestResponsePage<EmployeeDetails> employees;
}
