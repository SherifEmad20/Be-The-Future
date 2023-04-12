package com.example.BeTheFutureBackend.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskName(String taskName);
    List<Task> findAllByProductId(Long productId);
}
