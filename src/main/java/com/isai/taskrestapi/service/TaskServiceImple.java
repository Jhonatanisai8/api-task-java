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
            throw new EntityNotFoundException("Tarea no Encontrada.");
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
    public List<Optional<Task>> findTaskByStatus(StatusTask status) {
        return taskRepository.findTaskByStatus(status);
    }

    @Override
    public List<Optional<Task>> findTaskByStatusIgnoreCase(String status) {
        StatusTask statusTask = StatusTask.valueOf(status.toLowerCase());
        return taskRepository.findTaskByStatusIgnoreCase(statusTask.name());
    }

    @Override
    public Optional<Task> findTaskByTittleIgnoreCase(String tittle) {
        return taskRepository.findTaskByTittleIgnoreCase(tittle);
    }
}
