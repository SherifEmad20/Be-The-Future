import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/admin';

  getAdminsList(): Observable<Admin[]>{
    return this.http.get<Admin[]>(this.baseUrl+'/getAllAdmins');
  }

  addAdmin(admin: Admin): Observable<Object>{
    return this.http.post<Admin>(this.baseUrl+'/addAdmin', admin);
  }

  LoginAdmin(admin: Admin): Observable<Object>{
    return this.http.post<Admin>(this.baseUrl+'/login', admin);
  }
}
