import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { OnboardEmployeeComponent } from './onboard-employee/onboard-employee.component';
import { ManageEmployeesComponent } from './manage-employees/manage-employees.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDatepickerModule, DatepickerModule } from 'ngx-bootstrap/datepicker';
import { HttpClientModule }    from '@angular/common/http';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';



@NgModule({
  declarations: [OnboardEmployeeComponent, ManageEmployeesComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    DatepickerModule.forRoot(),
    HttpClientModule,
    NgxDatatableModule
  ],
  exports : [
    OnboardEmployeeComponent,
    ManageEmployeesComponent
  ]
})
export class AdminModule { }
