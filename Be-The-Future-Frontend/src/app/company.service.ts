import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from './company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/company';

  getCompaniesList(): Observable<Company[]>{
    return this.http.get<Company[]>(this.baseUrl+'/getAllCompanies');
  }

  addCompany(company: Company): Observable<Object>{
    return this.http.post<Company>(this.baseUrl+'/add_company', company);
  }

  addManagerToComoany(mangerUsername:String, companyID:number): Observable<Object>{
    return this.http.put(`${this.baseUrl}/addManagerToCompany/${mangerUsername}/${companyID}`, null);
  }
}
