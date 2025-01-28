package com.isai.taskrestapi.service;

import com.isai.taskrestapi.Exceptions.EntityNotFoundException;
import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.model.enums.StatusTask;
import com.isai.taskrestapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Task findTaskById(Long id) throws EntityNotFoundException {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new EntityNotFoundException("Tarea no Encontrada con ID: " + id);
        }
        return task.get();
    }

    @Override
    public Task updateTask(Long taksID, Task task) throws EntityNotFoundException {
        Task taskBD = findTaskById(taksID);

        if (Objects.nonNull(task.getTittle()) && !task.getTittle().isEmpty()) {
            taskBD.setTittle(task.getTittle());
        }
        if (Objects.nonNull(task.getDescription()) && !task.getDescription().isEmpty()) {
            taskBD.setDescription(task.getDescription());
        }
        if (Objects.nonNull(task.getStatus())) {
            taskBD.setStatus(task.getStatus());
        }
        return taskRepository.save(taskBD);
    }

    @Override
    public Task deleteTaskById(Long taksID) throws EntityNotFoundException {
        Task taskBD = findTaskById(taksID);
        taskRepository.delete(taskBD);
        return taskBD;
    }

    @Override
    public List<Optional<Task>> findTaskByStatus(StatusTask status) throws EntityNotFoundException {
        List<Optional<Task>> tasksLists = taskRepository.findTaskByStatus(status);
        if (tasksLists.isEmpty()) {
            throw new EntityNotFoundException("Tareas no encontradas con Estado: " + status.name());
        }
        return tasksLists;
    }

    @Override
    public List<Task> findTaskByStatusIgnoreCase(String status) throws IllegalArgumentException {
        if (status.equalsIgnoreCase("pending")
                || status.equalsIgnoreCase("in_progress")
                || status.equalsIgnoreCase("completed")) {
            StatusTask statusTask = StatusTask.valueOf(status.toLowerCase());
            List<Optional<Task>> taskBD = taskRepository.findTaskByStatusIgnoreCase(statusTask.name());
            return taskBD.stream()
                    .map(Optional::get)
                    .toList();
        } else {
            throw new IllegalArgumentException("No se Encontro tareas con dicho estado: " + status);
        }

    }

    @Override
    public Optional<Task> findTaskByTittleIgnoreCase(String tittle) {
        return taskRepository.findTaskByTittleIgnoreCase(tittle);
    }
}
