import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, private router:Router) { }

  private registerEmployee():void{
    this.employeeService.signupEmployee(this.employee).subscribe(data => {
      console.log(data)
    })
    this.goToHomePage();
  }

  goToHomePage(){
    this.router.navigate(['/login'])
  }

  onSubmit(){
    this.registerEmployee();
  }


}
