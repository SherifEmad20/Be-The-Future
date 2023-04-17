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
    public Iterable<Task> getAllTasksByProduct(@PathVariable Long productId) {
        return taskModel.getAllTasksByProduct(productId);
    }

    @GetMapping("/getAllDoneTasks")
    public Iterable<Task> getAllDoneTasks() {
        return taskModel.getAllDoneTasks();
    }

    @PostMapping("/add_task/{productName}/{employeeName}")
    public Boolean addTask(@RequestBody Task task, @PathVariable String productName, @PathVariable String employeeName) {
        return taskModel.addTask(task, productName, employeeName);
    }

    @GetMapping("/getAllTasks")
    public Iterable<Task> getAllTasks() {
        return taskModel.getAllTasks();
    }


    // get task by employee name
    @GetMapping("/getTaskByEmployeeName/{employeeName}")
    public Iterable<Task> getTaskByEmployeeName(@PathVariable("employeeName") String employeeName) {
        return taskModel.getTaskByEmployeeName(employeeName);
    }


    //addTaskToEmployee
   @PutMapping("/add_taskToEmployee/{employeeName}")
    public Boolean addTaskToEmployee(@RequestBody Task task, @PathVariable String employeeName) {
        return taskModel.addTaskToEmployee(task, employeeName);
    }

    @GetMapping("/getAllDroppedTasks")
    public Iterable<Task> getAllDroppedTasks() {
        return taskModel.getAllDroppedTasks();
    }


    @PutMapping("/doneTask/{taskName}")
    public Task doneTask(@PathVariable("taskName") String taskName) {
        return taskModel.doneTask(taskName);
    }

    @PutMapping("/inProgressTask/{taskName}")
    public Task inProgressTask(@PathVariable("taskName") String taskName) {
        return taskModel.inProgressTask(taskName);
    }


    @PutMapping("/droppedTask/{taskName}")
    public Task droppedTask(@PathVariable("taskName") String taskName) {
        return taskModel.droppedTask(taskName);
    }
}
