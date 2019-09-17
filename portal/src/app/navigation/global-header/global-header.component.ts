import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-global-header',
  templateUrl: './global-header.component.html',
  styleUrls: ['./global-header.component.css']
})
export class GlobalHeaderComponent implements OnInit {

  @Output() onShowSideBar : EventEmitter<boolean> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  showSideNav() {
    this.onShowSideBar.emit(true);
  }

}
