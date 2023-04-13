package com.example.BeTheFutureBackend.Manager;

import com.example.BeTheFutureBackend.Task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/manager")
@CrossOrigin(origins = "*")
public class MangerController {
    ManagerModel managerModel;

    @Autowired
    public MangerController(ManagerModel managerModel) {
        this.managerModel = managerModel;
    }

    @PostMapping(path = "register")
    public Manager addManager(@RequestBody Manager manager) {
        System.out.println(manager);
        return managerModel.addManager(manager);
    }

    //sign in
    @PostMapping(path = "login")
    public ResponseEntity<?> logIn(@RequestBody Manager manager) {
        return managerModel.managerExists(manager);
    }

    @PutMapping(path = "update")
    public Manager updateManager(@RequestBody Manager manager) {
        return managerModel.updateManager(manager);
    }

    @DeleteMapping(path = "delete/{userName}")
    public void deleteManager(@PathVariable("userName") String userName) {
        managerModel.deleteManager(userName);
    }

    @GetMapping(path = "get/{userName}")
    public Manager getManager(@PathVariable("userName") String userName) {
        return managerModel.getManager(userName).orElse(null);
    }

    @GetMapping(path = "getManagers")
    public Iterable<Manager> getAllManagers() {
        return managerModel.getAllManagers();
    }

    @PutMapping("addTask/{userName}/{taskID}")
    public String addTask(@PathVariable("userName") String employeeName, @PathVariable("taskID") long taskID) {
        return managerModel.addTaskToEmployee(employeeName, taskID);
    }

}
