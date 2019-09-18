import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { EmployeeDetails } from '../model/employee-details';
import { SearchEmployeeResponse } from '../model/search-employee-response';
import { ColumnMode } from '@swimlane/ngx-datatable';
import { Page } from '../model/page';
import { PagedData } from '../model/paged-data';

@Component({
  selector: 'app-manage-employees',
  templateUrl: './manage-employees.component.html',
  styleUrls: ['./manage-employees.component.css']
})
export class ManageEmployeesComponent implements OnInit {

  rows : EmployeeDetails [] = [];
  page : Page = new Page();
  pageData : PagedData<EmployeeDetails> = new PagedData<EmployeeDetails>();
  sort : string = 'firstName,ASC';

  showEmployeeAdd : boolean = false;


  ColumnMode = ColumnMode;
  
  columns = [
    { name: 'LastName' , sortable : true},
    { name: 'FirstName', sortable : true },
    { name: 'Gender', sortable : false },
    { name: 'Age', sortable : false },
    { name: 'Department', sortable : false }
  ];

  constructor(private employeeService : EmployeeService) { }

  ngOnInit() {
    this.fetchData();
  }

  setPage(page : Page) {
    this.page.pageNumber = page.offset;
    this.fetchData();
  }

  onSort(sort) {

    this.sort = sort.sorts[0].prop + ',' + sort.sorts[0].dir
    console.log(sort);
    this.fetchData();
  }

  fetchData() {
    this.employeeService.listAllEmployees(this.page, this.sort).subscribe((result : SearchEmployeeResponse) => {
      this.pageData = result.employees;
      this.page = result.employees.pageable;
      this.rows = result.employees.content;
      console.log(result);
    })
  }

  onAddEmployee() {
    this.showEmployeeAdd = true;
  }

  onAddComplete() {
    this.showEmployeeAdd = false;
  }

}
