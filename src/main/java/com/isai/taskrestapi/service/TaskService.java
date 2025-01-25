package com.isai.taskrestapi.service;

import com.isai.taskrestapi.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();

    Task saveTask(Task task);
}
