package com.isai.taskrestapi.service;

import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImple
        implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {
        System.out.println("Tareas obtenidas: " + taskRepository.findAll().size());
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findTaskById(Long id) {
        return taskRepository.findById(id).get();
    }
}
