import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-damage-report',
  templateUrl: './damage-report.component.html',
  styleUrls: ['./damage-report.component.css']
})
export class DamageReportComponent implements OnInit {

  public name: string;
  public email: string;
  constructor() { }

  ngOnInit() {
  }

}
