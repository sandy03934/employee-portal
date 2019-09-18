package com.sandy03934.employeeportal.service;

import com.sandy03934.employeeportal.dto.rest.request.RegisterEmployeeRequest;
import com.sandy03934.employeeportal.dto.rest.response.RegisterEmployeeResponse;

public interface RegistrationService {

    RegisterEmployeeResponse register(RegisterEmployeeRequest request);
}
