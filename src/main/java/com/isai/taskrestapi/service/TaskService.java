package com.isai.taskrestapi.service;

import com.isai.taskrestapi.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();

    Task saveTask(Task task);

    Task findTaskById(Long id);

    Task updateTask(Long taksID, Task task);

    Task deleteTaskById(Long taksID);
}
