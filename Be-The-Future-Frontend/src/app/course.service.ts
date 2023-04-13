import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/course';


  addCourse(course: Course): Observable<Object>{
    return this.http.post<Course>(`${this.baseUrl}/addCourse`, course);
  }

  getCourses(): Observable<Course[]>{
    return this.http.get<Course[]>(`${this.baseUrl}/getAllCourses`);
  }

  getCourseById(id:String): Observable<Object>{
    return this.http.get(`${this.baseUrl}/getCourse/${id}`);
  }

  updateCourse(course: Course): Observable<Object>{
    return this.http.put(`${this.baseUrl}/updateCourse`, course);
  }


  deleteCourse(id:String): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/deleteCourse/${id}`);
  }


  voteApproveCourse(id:String): Observable<Object>{
    return this.http.put(`${this.baseUrl}/voteToApproveCourse/${id}`, null);
  }

  voteDisapproveCourse(id:String): Observable<Object>{
    return this.http.put(`${this.baseUrl}/voteToDisapproveCourse/${id}`, null);
  }

  approveCourse(id:String): Observable<Object>{
    return this.http.put(`${this.baseUrl}/approveCourse/${id}`, null);
  }


}
