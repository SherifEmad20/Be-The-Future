import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/employee';

  getEmployeesList(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+'/getAllEmployees');
  }

  signupEmployee(employee: Employee): Observable<Object>{
    return this.http.post<Employee>(this.baseUrl+'/register', employee);
  }

  LoginEmployee(employee: Employee): Observable<Object>{
    return this.http.post<Employee>(this.baseUrl+'/login', employee);
  }

  updateEmployee(id:number, employee:Employee):Observable<Object>{
    return this.http.put(this.baseUrl+'/updateEmployee', employee)
  }

  deleteEmployee(username: String):Observable<Object>{
    return this.http.delete(`${this.baseUrl}+'/deleteEmployee/${username}`)
  }

  getByEmployee(username: String):Observable<Object>{
    return this.http.get(`${this.baseUrl}+'/deleteEmployee/${username}`)
  }

}
