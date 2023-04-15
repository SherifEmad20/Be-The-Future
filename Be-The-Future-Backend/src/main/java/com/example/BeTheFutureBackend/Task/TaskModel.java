package com.example.BeTheFutureBackend.Task;

import com.example.BeTheFutureBackend.product.Product;
import com.example.BeTheFutureBackend.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskModel {
    private final TaskRepository taskRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TaskModel(TaskRepository taskRepository, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getAllTasks(Long productId) {
        return taskRepository.findAllByProductId(productId);
    }

    public Task getTaskByTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }


    public Boolean addTask(Task task, Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product == null) {
            return false;
        } else {
            Product product1 = product.get();
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

    public Task inProgressTask(String taskName) {
        Task task = taskRepository.findByTaskName(taskName);
        task.setDone(false);
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).get();
    }
}
