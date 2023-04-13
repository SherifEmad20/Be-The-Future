import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  employee: Employee = new Employee();
  
  returnedData: any;



  constructor(private employeeService: EmployeeService, private router:Router) { }

  ngOnInit() {
  }

  login() {
    this.employeeService
    .LoginEmployee(this.employee).subscribe(data => {
        console.log("login successful")
        alert("login successful")
        this.goToHomePage()
    }, 
    error => {
      console.log("login failed")
      alert("login failed")
    })
    
  }

  goToHomePage(){
    this.router.navigate(['/home-page'])
  }

  onSubmit() {
    this.login();    
  }


}
