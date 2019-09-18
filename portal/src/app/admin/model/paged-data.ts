import { Page } from './page';

export class PagedData<T> {
    content = new Array<T>();
    pageable = new Page();
    size: number = 10;
    totalElements: number = 0;
    totalPages: number = 0;
    number: number = 0;
    numberOfElements : number = 0;
  }
