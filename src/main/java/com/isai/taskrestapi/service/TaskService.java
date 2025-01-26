package com.isai.taskrestapi.service;

import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.model.enums.StatusTask;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTask();

    Task saveTask(Task task);

    Task findTaskById(Long id);

    Task updateTask(Long taksID, Task task);

    Task deleteTaskById(Long taksID);

    List<Optional<Task>> findTaskByStatus(StatusTask status);

}
