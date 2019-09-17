import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GlobalSidenavComponent } from './global-sidenav/global-sidenav.component';
import { GlobalHeaderComponent } from './global-header/global-header.component';
import { GlobalFooterComponent } from './global-footer/global-footer.component';
import { AppRoutingModule } from '../app-routing.module';




@NgModule({
  declarations: [GlobalSidenavComponent, GlobalHeaderComponent, GlobalFooterComponent],
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  exports : [
    GlobalSidenavComponent,
    GlobalHeaderComponent
  ]
})
export class NavigationModule { }
