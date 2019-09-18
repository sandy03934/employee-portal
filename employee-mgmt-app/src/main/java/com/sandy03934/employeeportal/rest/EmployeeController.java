package com.sandy03934.employeeportal.rest;

import com.sandy03934.employeeportal.dto.rest.request.RegisterEmployeeRequest;
import com.sandy03934.employeeportal.dto.rest.response.RegisterEmployeeResponse;
import com.sandy03934.employeeportal.dto.rest.response.SearchEmployeeResponse;
import com.sandy03934.employeeportal.service.EmployeeSearchService;
import com.sandy03934.employeeportal.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    EmployeeSearchService employeeSearchService;

    @PostMapping("/register")
    public ResponseEntity<RegisterEmployeeResponse> registerEmployee(@RequestBody RegisterEmployeeRequest employee) {

        RegisterEmployeeResponse response = registrationService.register(employee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<SearchEmployeeResponse> searchEmployees(Pageable page) {
        SearchEmployeeResponse response = employeeSearchService.getAllEmployees(page);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
