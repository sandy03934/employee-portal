import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-global-sidenav',
  templateUrl: './global-sidenav.component.html',
  styleUrls: ['./global-sidenav.component.css']
})
export class GlobalSidenavComponent implements OnInit {

  @Input() showSidebar : boolean = false;

  @Output() onCloseSidebar : EventEmitter<any> = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  onCloseSideNav() {
    this.showSidebar = false;
    this.onCloseSidebar.emit();
  }

}
