package com.sandy03934.employeeportal;

import com.sandy03934.employeeportal.dto.rest.request.RegisterEmployeeRequest;
import com.sandy03934.employeeportal.dto.rest.response.RegisterEmployeeResponse;
import com.sandy03934.employeeportal.dto.rest.response.SearchEmployeeResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeServiceApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	@Test
	public void contextLoads() {
	}

	@Test
	public void whenEmployeeAdded_ThenSuccessful() {
		RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
				.department("abc")
				.dob(Date.from(Instant.parse("2011-12-03T10:15:30Z")))
				.firstName("Sam")
				.lastName("Pitroda")
				.gender("Male")
				.build();

		ResponseEntity<RegisterEmployeeResponse> response = restTemplate.postForEntity("/api/employees/register", request, RegisterEmployeeResponse.class);

		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);

	}

	@Test
	public void whenEmployeeAdded_ThenSearchSuccessful() {
		RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
				.department("abc")
				.dob(Date.from(Instant.parse("2011-12-03T10:15:30Z")))
				.firstName("Sam")
				.lastName("Pitroda")
				.gender("Male")
				.build();

		ResponseEntity<RegisterEmployeeResponse> response = restTemplate.postForEntity("/api/employees/register", request, RegisterEmployeeResponse.class);

		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);

		ResponseEntity<SearchEmployeeResponse> resp =  restTemplate.getForEntity("/api/employees/", SearchEmployeeResponse.class);
		assertNotNull(resp);
		assertEquals(resp.getStatusCode(), HttpStatus.OK);

		assertNotNull(resp.getBody());
		assertNotNull(resp.getBody().getEmployees());
		assertEquals(2, resp.getBody().getEmployees().getTotalElements());
	}

}
