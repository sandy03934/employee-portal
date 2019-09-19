# Employee Portal

A demo application which has the following functionalities

- Add a new Employee Record
- View the Employees Record

## Tech

- Java 8
- Maven
- Spring Boot
- Angular
- HTML
- Bootstrap
- NGX-Datatable
- NGX-Bootstrap


## Build Steps

### Installation

- Apache Maven (>3.5)
- Node

### Project Structure 

The project is a multi module maven project where it ensembles the front end angular code in the Spring Boot Jar Application as static resources

### Maven Build

From the top level project directory, execute the below maven command from command line

````
> mvn install
````

### Execution
From the above step there will be Spring Boot Jar available in the `employee_mgmt_app/target/employee-mgmt-app.jar` 


The application could be run by :

```jshelllanguage
> cd employee_mgmt_app
> mvn spring-boot:run
```

or it could be also executed from command line 
```jshelllanguage
> java -jar employee_mgmt_app/target/employee-mgmt-app.jar
```

The application should be up on http://localhost:8080/