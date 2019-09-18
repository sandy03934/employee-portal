import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SearchEmployeeResponse } from '../model/search-employee-response';
import { Page } from '../model/page';
import { sortRows } from '@swimlane/ngx-datatable';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http : HttpClient) { }

  registerEmployee(employee : Employee) {
    return this.http.post('/api/employees/register', employee)
  }

  listAllEmployees(page : Page, sort : string) {
    let params : HttpParams = new HttpParams()
                                .append('size',  page.pageSize.toString())
                                .append('page',  page.pageNumber.toString())
                                .append('sort', sort);
    return this.http.get<SearchEmployeeResponse>('/api/employees/', { params : params});
  }
}
