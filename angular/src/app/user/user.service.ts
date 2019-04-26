import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Messege } from '../models/Messege';
import { User } from '../models/user.model';
import { Login } from '../models/Login';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/user-portal/users';
  //private userUrl = '/api';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }
  public addUserToGroup(user): Observable<any> {
    return this.http.post<any>(this.userUrl+"/addToChatGroup", user);
  }

  public sendmsg(chat): Observable<any> {
    return this.http.post<any>(this.userUrl+"/sendmsg", chat);
  }
  public authenticateUser(user): Observable<any> {
  console.log(user);
    return this.http.post<any>(this.userUrl+"/login", user);
  }

  public fetchGroupMembers(user): Observable<any>{
  return this.http.post<any>(this.userUrl+"/getGroupMembers",user);
  }
  public getMesssges(user): Observable<any> {
    return this.http.post<any>(this.userUrl+"/getMessages",user);
  }
}
