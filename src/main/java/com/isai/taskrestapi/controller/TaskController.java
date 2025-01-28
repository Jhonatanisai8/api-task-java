package com.isai.taskrestapi.controller;

import com.isai.taskrestapi.Exceptions.EntityNotFoundException;
import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.model.enums.StatusTask;
import com.isai.taskrestapi.service.TaskServiceImple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImple serviceImple;

    @GetMapping("/getAllTask")
    public List<Task> getAllTask() {
        return serviceImple.getAllTask();
    }

    @GetMapping("/findTaskById/{taksID}")
    public Task findTaskById(@PathVariable Long taksID) throws EntityNotFoundException {
        return serviceImple.findTaskById(taksID);
    }

    @GetMapping("/findTaskByStatus/{status}")
    public List<Optional<Task>> findTaskByStatus(@PathVariable StatusTask status) throws EntityNotFoundException {
        return serviceImple.findTaskByStatus(status);
    }

    @GetMapping("/findTaskByStatusIgnoreCase/{status}")
    public List<Task> findTaskByStatusIgnoreCase(@PathVariable String status) throws IllegalArgumentException {
        return serviceImple.findTaskByStatusIgnoreCase(status);
    }

    @GetMapping("/findTaskByTittleIgnoreCase/{tittle}")
    public Optional<Task> findTaskByTittleIgnoreCase(@PathVariable String tittle) {
        return serviceImple.findTaskByTittleIgnoreCase(tittle);
    }

    @PostMapping("/saveTask")
    public Task saveTask(@Valid @RequestBody Task task) {
        return serviceImple.saveTask(task);
    }

    @PutMapping("/updateTask/{taksID}")
    public Task updateTask(@PathVariable Long taksID, @Valid @RequestBody Task task) throws EntityNotFoundException {
        return serviceImple.updateTask(taksID, task);
    }

    @DeleteMapping("/deleteTask/{taksID}")
    public Task deleteTaskById(@PathVariable Long taksID) throws EntityNotFoundException {
        return serviceImple.deleteTaskById(taksID);
    }


}
