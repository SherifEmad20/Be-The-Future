import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/customer';

  addCustomer(customer: Customer): Observable<Object>{
    return this.http.post<Customer>(`${this.baseUrl}/add_customer`, customer);
  }

  getCustomers(): Observable<Customer[]>{
    return this.http.get<Customer[]>(`${this.baseUrl}/getAllCustomers`);
  }

  getCustomerById(id:String): Observable<Object>{
    return this.http.get(`${this.baseUrl}/getCustomerById/${id}`);
  }

  updateCustomer(customer: Customer): Observable<Object>{
    return this.http.put(`${this.baseUrl}/updateCustomer`, customer);
  }

  signupCustomer(customer: Customer): Observable<Object>{
    return this.http.post<Customer>(this.baseUrl+'register', customer);
  }

  LoginCustomer(customer: Customer): Observable<Object>{
    return this.http.post<Customer>(this.baseUrl+'login', customer);
  }

  deleteCustomer(id:String): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/deleteCustomer/${id}`);
  }

}
