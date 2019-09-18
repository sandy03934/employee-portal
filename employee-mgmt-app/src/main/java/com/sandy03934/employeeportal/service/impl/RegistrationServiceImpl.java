package com.sandy03934.employeeportal.service.impl;

import com.sandy03934.employeeportal.domain.Employee;
import com.sandy03934.employeeportal.dto.error.Error;
import com.sandy03934.employeeportal.dto.rest.request.RegisterEmployeeRequest;
import com.sandy03934.employeeportal.dto.rest.response.RegisterEmployeeResponse;
import com.sandy03934.employeeportal.repositories.EmployeeRepository;
import com.sandy03934.employeeportal.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public RegisterEmployeeResponse register(RegisterEmployeeRequest request) {

        RegisterEmployeeResponse response = new RegisterEmployeeResponse();

        try {
            Objects.requireNonNull(request, "Registration Request Must not be null");

            Employee employee = new Employee();
            employee.setPublicId(UUID.randomUUID().toString());
            employee.setDepartment(request.getDepartment());
            employee.setDob(request.getDob());
            employee.setFirstName(request.getFirstName());
            employee.setLastName(request.getFirstName());
            employee.setGender(request.getGender());

            Employee emp = employeeRepository.save(employee);

            response.setPublicId(emp.getPublicId());

        } catch (Exception e) {
            response.addError(new Error(e.getMessage(), "Internal Server Error"));
        }

        return response;
    }
}
