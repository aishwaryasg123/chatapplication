import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Group } from '../models/Group.model';
import { UserService } from '../user/user.service';
import { User } from '../models/user.model';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
 user: Group = new Group();
  // user: User = new User();
 users: User[];
 flag=false
 constructor(private router: Router, private userService: UserService) {

  }
  ngOnInit() {
  	 this.userService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  }
  
list():void{
   this.flag=true
}
  addUserToGroup(): void {
    this.userService. addUserToGroup(this.user)
        .subscribe( data => {
          alert("User added successfully.");
        });

  };
  createUser(): void {
    this.userService.createUser(this.user)
        .subscribe( data => {
          this.users.push(data)
          alert("User created successfully.");
        });

  };
  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };
  
}
