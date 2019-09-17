import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'portal';

  showSideBar : boolean = false;

  onShowSideBar() {
    this.showSideBar =  true;
  }

  closeSideBar() {
    this.showSideBar = false;
  }
}


