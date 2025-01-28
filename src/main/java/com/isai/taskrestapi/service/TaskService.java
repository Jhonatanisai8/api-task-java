package com.isai.taskrestapi.service;

import com.isai.taskrestapi.Exceptions.EntityNotFoundException;
import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.model.enums.StatusTask;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTask();

    Task saveTask(Task task);

    Task findTaskById(Long id) throws EntityNotFoundException;

    Task updateTask(Long taksID, Task task) throws EntityNotFoundException;

    Task deleteTaskById(Long taksID)  throws EntityNotFoundException;

    List<Optional<Task>> findTaskByStatus(StatusTask status);

    List<Optional<Task>> findTaskByStatusIgnoreCase(String status);

    Optional<Task> findTaskByTittleIgnoreCase(String tittle);

}
