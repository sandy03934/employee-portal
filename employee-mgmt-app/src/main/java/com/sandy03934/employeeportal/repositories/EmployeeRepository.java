package com.sandy03934.employeeportal.repositories;

import com.sandy03934.employeeportal.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Optional<Employee> findByPublicId(String publicId);
}
