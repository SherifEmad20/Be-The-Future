package com.example.BeTheFutureBackend.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/task")
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskModel taskModel;

    @Autowired
    public TaskController(TaskModel taskModel) {
        this.taskModel = taskModel;
    }

    @GetMapping("/getTaskById/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskModel.getTask(id);
    }

    @GetMapping("/getAllTasks/{productId}")
    public Iterable<Task> getAllTasks(@PathVariable Long productId) {
        return taskModel.getAllTasks(productId);
    }

    @PostMapping("/add_task/{productId}")
    public Boolean addTask(@RequestBody Task task, @PathVariable Long productId) {
        return taskModel.addTask(task, productId);
    }

    //addTaskToEmployee
   @PutMapping("/add_taskToEmployee/{employeeName}")
    public Boolean addTaskToEmployee(@RequestBody Task task, @PathVariable String employeeName) {
        return taskModel.addTaskToEmployee(task, employeeName);
    }


    @PutMapping("/doneTask/{taskName}")
    public Task doneTask(@PathVariable("taskName") String taskName) {
        return taskModel.doneTask(taskName);
    }

    @PutMapping("/inProgressTask/{taskName}")
    public Task inProgressTask(@PathVariable("taskName") String taskName) {
        return taskModel.inProgressTask(taskName);
    }
}
