package com.sandy03934.employeeportal.service.impl;

import com.sandy03934.employeeportal.domain.Employee;
import com.sandy03934.employeeportal.dto.error.Error;
import com.sandy03934.employeeportal.dto.rest.response.EmployeeDetails;
import com.sandy03934.employeeportal.dto.rest.response.RestResponsePage;
import com.sandy03934.employeeportal.dto.rest.response.SearchEmployeeResponse;
import com.sandy03934.employeeportal.repositories.EmployeeRepository;
import com.sandy03934.employeeportal.service.EmployeeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Service
public class EmployeeSearchServiceImpl implements EmployeeSearchService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public SearchEmployeeResponse getAllEmployees(@PageableDefault Pageable pageRequest) {
        SearchEmployeeResponse response = new SearchEmployeeResponse();

        try {
           response.setEmployees(toEmployeeDetails(employeeRepository.findAll(pageRequest)));
        } catch (Exception e) {
            response.addError(new Error(e.getMessage(), "Internal Server Error"));
        }

        return response;
    }

    private RestResponsePage<EmployeeDetails> toEmployeeDetails(Page<Employee> employees) {
        Page<EmployeeDetails> employeeDetails = employees.map(this::toEmployeeDetail);
        return new RestResponsePage<>(employeeDetails.getContent(), employeeDetails.getPageable(), employeeDetails.getTotalElements());
    }

    private EmployeeDetails toEmployeeDetail(Employee employee) {
        return EmployeeDetails.builder()
                .department(employee.getDepartment())
                .age(calculateAge(employee.getDob()))
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .publicId(employee.getPublicId())
                .build();
    }

    private Integer calculateAge(Date dob) {
        Calendar c = Calendar.getInstance();
        c.setTime(dob);
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1;
        int date=c.get(Calendar.DATE);
        return Period.between(LocalDate.of(year, month, date), LocalDate.now()).getYears();
    }
}
