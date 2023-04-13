import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/v1/product';

  addProduct(product: Product, customerName:String): Observable<Object>{
    return this.http.post<Product>(`${this.baseUrl}/add_productByCustomerName/${customerName}`, product);
  }

  getProductsList(): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+'/getAllProducts');
  }

  getProductBycustomerName(customerName:String): Observable<Object>{
    return this.http.get(`${this.baseUrl}/getProductBycustomerName/${customerName}`);
  }

  getProductById(id:number): Observable<Object>{
    return this.http.get(`${this.baseUrl}/getProductById/${id}`);
  }

  updateProduct(product: Product): Observable<Object>{
    return this.http.put(`${this.baseUrl}/updateProduct`, product);
  }

  deleteProduct(id:number): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/deleteProduct/${id}`);
  }


}
