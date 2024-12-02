import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserRequest } from '../models/user-request';
import { Observable } from 'rxjs';
import { UserResponse } from '../models/user-response';
import { ChangePassword } from '../models/change-password';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private API_URL= 'http://localhost:8080/api/v1/users';

  constructor(private http: HttpClient) { }
  createUser(userRequest: UserRequest): Observable<void>{
    return this.http.post<void>(this.API_URL, userRequest);
  }
  getUser(id: String): Observable<UserResponse>{
    return this.http.get<UserResponse>(`${this.API_URL}/${id}`);
  }
  getAllUser(): Observable<UserResponse[]>{
    return this.http.get<UserResponse[]>(`${this.API_URL}`);
  }
  deleteUser(id: String): Observable<void>{
    return this.http.delete<void>(`${this.API_URL}/${id}`);
  }
  updateUser(id: String, userRequest: UserRequest): Observable<void>{
    return this.http.put<void>(`${this.API_URL}/${id}`, userRequest);
  }
  updatePassword(id: String, changePassword: ChangePassword): Observable<void>{
    return this.http.put<void>(`${this.API_URL}/${id}/password`,changePassword);
  }
}
