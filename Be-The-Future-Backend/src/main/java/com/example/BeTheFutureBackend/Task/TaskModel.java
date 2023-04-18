package com.example.BeTheFutureBackend.Task;

import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import com.example.BeTheFutureBackend.product.Product;
import com.example.BeTheFutureBackend.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskModel {
    private final TaskRepository taskRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskModel(TaskRepository taskRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Task> getAllTasksByProduct(Long productId) {
        return taskRepository.findAllByProductId(productId);
    }

    // get all tasks
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }

    public Boolean addTask(Task task, String productName, String employeeName) {
        Optional<Product> product = productRepository.findByProductName(productName);
        if (product == null) {
            return false;
        } else {
            Product product1 = product.get();
            User user = new User();

            for (User user1 : userRepository.findAll()) {
                if (user1.getUsername().equals(employeeName)) {
                    user = user1;
                }
            }
            task.setEmployee(user);
            product1.addTask(task);
            productRepository.save(product1);
            task.setProduct(product1);
            taskRepository.save(task);
            return true;
        }
    }

    public Task doneTask(String taskName) {
        Task task = taskRepository.findByTaskName(taskName);
        task.setDone(true);
        return taskRepository.save(task);
    }

    public Task droppedTask(String taskName) {
        Task task = taskRepository.findByTaskName(taskName);
        task.setDropped(true);
        return taskRepository.save(task);
    }


    public Iterable<Task> getAllDoneTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            if (task.isDone()) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public Task inProgressTask(String taskName) {
        Task task = taskRepository.findByTaskName(taskName);
        task.setDone(false);
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).get();
    }


    public Iterable<Task> getTaskByEmployeeName(String employeeName) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            if (task.getEmployeeName().equals(employeeName) && !task.isDone() && !task.getDropped()) {
                tasks.add(task);
            }
        }

        return tasks;
    }

    public Iterable<Task> getAllDroppedTasks() {

        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            if (task.getDropped() && !task.isDone()) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public Boolean addTaskToEmployee(Task task, String employeeName) {
        Task task1 = taskRepository.findByTaskName(task.getTaskName());
        if (task1 == null) {
            return false;
        } else {
            task1.setEmployeeName(employeeName);
            taskRepository.save(task1);
            return true;
        }
    }
}
