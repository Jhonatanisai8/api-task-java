package com.isai.taskrestapi.repository;

import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.model.enums.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long> {
    @Query("SELECT l FROM Task l WHERE l.status = :status")
    List<Optional<Task>> findTaskByStatus(@Param("status") StatusTask status);

}
