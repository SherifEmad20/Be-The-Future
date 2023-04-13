package com.example.BeTheFutureBackend.Manager;

import com.example.BeTheFutureBackend.Company.Company;
import com.example.BeTheFutureBackend.Employee.Employee;
import com.example.BeTheFutureBackend.Employee.EmployeeRepository;
import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.Task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerModel {
    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public ManagerModel(ManagerRepository managerRepository, EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<?> register(Manager manager) {
        if (managerRepository.existsById(manager.getUserName())) {
            throw new IllegalStateException("username already exists");
        }
        if (managerRepository.existsById(manager.getEmail())) {
            throw new IllegalStateException("email already exists");
        }
        return ResponseEntity.ok(managerRepository.save(manager));
    }

    //search if the manager exists for login
    public ResponseEntity<?> login(Manager manager) {
        //check if manager exists by user name or email and password
        Iterable<Manager> managers = managerRepository.findAll();
        for (Manager m : managers) {
            if (m.getUserName().equals(manager.getUserName()) || m.getEmail().equals(manager.getEmail())) {
                if (m.getPassword().equals(manager.getPassword())) {
                    return ResponseEntity.ok(m);
                }
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }
    //login with username and password
    public ResponseEntity<?> login(String username, String password) {
        if (managerRepository.existsById(username)) {
            Manager manager1 = managerRepository.findById(username).get();
            if (manager1.getPassword().equals(password)) {
                return ResponseEntity.ok(manager1);
            }
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }

    public Optional<Manager> getManager(String userName) {
        return managerRepository.findById(userName);
    }

    public Manager getManagerByEmail(String email) {
        return managerRepository.findByEmail(email);
    }

    public Manager getManagerByPhone(String phone) {
        return managerRepository.findByPhone(phone);
    }

    //get all managers
    public Iterable<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public void deleteManager(String userName) {
        managerRepository.deleteById(userName);
    }

    public Manager updateManager(Manager manager) {
        return managerRepository.save(manager);
    }

    //add company to manager
    public void addCompanyToManager(Manager manager, Company company) {
        manager.setCompany(company);
        managerRepository.save(manager);
    }

    // add task to employee
    public String addTaskToEmployee(String employeeName, long taskID) {
        Employee employee = employeeRepository.findById(employeeName).get();
        Task task = taskRepository.findById(taskID).get();
        employee.addTask(task);
        task.setEmployee(employee);
        taskRepository.save(task);
        employeeRepository.save(employee);
        return "Task added to employee " + employeeName;
    }
}
