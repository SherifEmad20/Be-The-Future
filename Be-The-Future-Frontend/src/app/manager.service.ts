import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Manager } from './manager';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/manager';

  signupManager(manager: Manager): Observable<Object>{
    return this.http.post<Manager>(this.baseUrl+'register', manager);
  }

  LoginManger(manager: Manager): Observable<Object>{
    return this.http.post<Manager>(this.baseUrl+'login', manager);
  }

  updateManager(manager: Manager): Observable<Object>{
    return this.http.put(`${this.baseUrl}/update`, manager);
  }

  getManagerById(id:String): Observable<Object>{
    return this.http.get(`${this.baseUrl}/get/${id}`);
  }

  deleteManager(id:String): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }

  getManagersList(): Observable<Manager[]>{
    return this.http.get<Manager[]>(this.baseUrl+'/getManagers');
  }

  addTask(employeeUsername:String, taskID:number): Observable<Object>{
    return this.http.put(`${this.baseUrl}/addTask/${employeeUsername}/${taskID}`, null);
  }







}
