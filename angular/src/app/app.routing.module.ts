import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ChatComponent  } from './chat/chat.component';
import { LoginComponent  } from './login/login.component';
import { UserboardComponent } from './userboard/userboard.component';


const routes: Routes = [
  { path: 'admin', component: AdminComponent },
  { path: 'chat', component: ChatComponent },
  { path: 'login', component: LoginComponent },
  { path: 'userboard', component: UserboardComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
