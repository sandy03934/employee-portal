import { EmployeeDetails } from './employee-details';
import { PagedData } from './paged-data';

export interface SearchEmployeeResponse {

    employees : PagedData<EmployeeDetails>;

    errors : Error[];
}
