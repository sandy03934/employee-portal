import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GlobalSidenavComponent } from './global-sidenav.component';

describe('GlobalSidenavComponent', () => {
  let component: GlobalSidenavComponent;
  let fixture: ComponentFixture<GlobalSidenavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GlobalSidenavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GlobalSidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
