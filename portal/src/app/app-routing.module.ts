import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OnboardEmployeeComponent } from './admin/onboard-employee/onboard-employee.component';
import { ManageEmployeesComponent } from './admin/manage-employees/manage-employees.component';


const routes: Routes = [
  {path : '', redirectTo : 'admin/list/employee', pathMatch:'full'},
  {path : 'admin/onboard/employee', component : OnboardEmployeeComponent},
  {path : 'admin/list/employee', component : ManageEmployeesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
