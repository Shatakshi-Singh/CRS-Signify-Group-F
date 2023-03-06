import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/model/login';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
professorArray:Array<Login>= new Array();
model=new Login('','');
  constructor() { }

  ngOnInit(): void {
  }

}
