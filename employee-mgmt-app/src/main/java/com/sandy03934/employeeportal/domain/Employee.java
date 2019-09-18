package com.sandy03934.employeeportal.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @GeneratedValue(strategy = Generated)
    private String publicId;

    private String firstName;

    private String lastName;

    @Column(name = "date_of_birth")
    private Date dob;

    private String gender;

    private String department;
}
