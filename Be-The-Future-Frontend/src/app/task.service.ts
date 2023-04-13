import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from './task';  

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/task';

  addTask(task: Task, productId:number): Observable<Object>{
    return this.http.post<Task>(`${this.baseUrl}/add_task/${productId}`, task);
  }

  getTaskById(taskId:number): Observable<Object>{
    return this.http.get(`${this.baseUrl}/getTaskById/${taskId}`);
  }

  getAllTasks(productId:number): Observable<Object>{
    return this.http.get(`${this.baseUrl}/getAllTasks/${productId}`);
  }

  doneTask(taskName: string): Observable<Object>{
    return this.http.put(`${this.baseUrl}/doneTask/${taskName}`, null);
  }

  inProgressTask(taskName: string): Observable<Object>{
    return this.http.put(`${this.baseUrl}/inProgressTask/${taskName}`, null);
  }



}
