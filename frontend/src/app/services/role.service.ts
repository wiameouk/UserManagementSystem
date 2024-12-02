import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RoleRequest } from '../models/role-request';
import { RoleResponse } from '../models/role-response';

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private API_URL= 'http://localhost:8080/api/v1/roles';

  constructor(private http: HttpClient) { }
  createRole(roleRequest: RoleRequest): Observable<void> {
    return this.http.post<void>(this.API_URL, roleRequest)
  }
  getRole(id: String):Observable<RoleResponse>{
    return this.http.get<RoleResponse>(`${this.API_URL}/${id}`);
  }
  getAllRoles(): Observable<RoleResponse[]>{
    return this.http.get<RoleResponse[]>(this.API_URL);
  }
  deleteRole(id: String): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/${id}`);
  }
  updateRole(id: String, roleRequest: RoleRequest): Observable<void>{
    return this.http.put<void>(`${this.API_URL}/${id}`, roleRequest);
  }  
}
