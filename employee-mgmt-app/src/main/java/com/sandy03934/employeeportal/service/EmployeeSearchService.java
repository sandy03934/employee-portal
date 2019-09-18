package com.sandy03934.employeeportal.service;

import com.sandy03934.employeeportal.dto.rest.response.SearchEmployeeResponse;
import org.springframework.data.domain.Pageable;

public interface EmployeeSearchService {

    SearchEmployeeResponse getAllEmployees(Pageable pageRequest);

}
