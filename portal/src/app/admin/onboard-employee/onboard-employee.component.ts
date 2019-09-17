import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { Employee } from '../model/employee';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-onboard-employee',
  templateUrl: './onboard-employee.component.html',
  styleUrls: ['./onboard-employee.component.css']
})
export class OnboardEmployeeComponent implements OnInit {

  employeeForm : FormGroup;

  datePickerConfig : Partial<BsDatepickerConfig> = new BsDatepickerConfig();  
  
  constructor(private formBuilder : FormBuilder,
    private employeeService : EmployeeService) { 
    this.datePickerConfig.containerClass = 'theme-dark-blue';
  }

  ngOnInit() {
    
    this.employeeForm = this.formBuilder.group({
      'firstName' : new FormControl('', [Validators.required]),
      'lastName' : new FormControl('', [Validators.required]),
      'gender' : new FormControl('', [Validators.required]),
      'dob' : new FormControl(new Date(), [Validators.required]),
      'department' : new FormControl('', [Validators.required])
    })
  }

  onRegisterEmployee() : void {
    if (this.employeeForm != null && this.employeeForm.valid) {
      let employee : Employee = new Employee();

      employee.firstName = this.employeeForm.controls.firstName.value;
      employee.lastName = this.employeeForm.controls.lastName.value;
      employee.department = this.employeeForm.controls.department.value;
      employee.dob = this.employeeForm.controls.dob.value;
      employee.gender = this.employeeForm.controls.gender.value;

      this.employeeService.registerEmployee(employee).subscribe(res => {
        console.log(res);
      });
    }
  }

}
