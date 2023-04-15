package com.example.BeTheFutureBackend.Manager;

import com.example.BeTheFutureBackend.Task.Task;
import com.example.BeTheFutureBackend.Users.User;
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

    @GetMapping(path = "getManagers")
    public Iterable<User> getAllManagers() {
        return managerModel.getAllManagers();
    }

    @PutMapping("addTask/{userName}/{taskID}")
    public String addTask(@PathVariable("userName") String employeeName, @PathVariable("taskID") long taskID) {
        return managerModel.addTaskToEmployee(employeeName, taskID);
    }

}
