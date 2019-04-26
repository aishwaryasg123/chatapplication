import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChatInfo } from '../models/ChatInfo.model';
import { UserService } from '../user/user.service';
import { Login } from '../models/Login';
import { User } from '../models/user.model';
import { Group } from '../models/Group.model';
@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
chat: ChatInfo = new ChatInfo();
chats:ChatInfo[];
groupMembers:Group[];
user: Login = new Login();
flag =false;
  constructor(private router: Router, private userService: UserService) {

  }
  ngOnInit() {
    
     this.user.email= sessionStorage.getItem('email')
  	this.userService.getMessages(this.user)
      .subscribe( data => {
        this.chats = data;
      });

      this.userService.fetchGroupMembers(this.user)
        .subscribe( data => {
        this.groupMembers=data;
        });
  }
//   viewmsg(): void {
//   this.userService.getMesssges(this.chat)
//       .subscribe( data => {
//         this.chats = data;
//       });
// }

  sendmsg(): void {
    this.userService.sendmsg(this.chat)
        .subscribe( data => {
         if(data.message==="false")
        	{
            
              alert("user is not in your group");
        	}
        	else
          alert("msg sent successfully.");
        
        });

  };

}
