import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../models/user.model';
import { Login } from '../models/Login';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
 user: User = new User();
  logininfo:Login = new Login();

  constructor(private router: Router, private userService: UserService) {

  }

   authenticateUser(): void {
    this.userService.authenticateUser(this.logininfo)
        .subscribe( data => {
           if(data.role==="user"){
            sessionStorage.setItem('email', data.email)
            this.router.navigate(['/userboard']);
          }
           else if(data.role==="admin"){
             sessionStorage.setItem('email', data.email)
             this.router.navigate(['/admin']);
          }
          else 
            alert("invalid user");
        });

  };
}
