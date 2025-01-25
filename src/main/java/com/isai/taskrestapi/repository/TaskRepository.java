package com.isai.taskrestapi.repository;

import com.isai.taskrestapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository
        extends JpaRepository<Task, Long> {
}
