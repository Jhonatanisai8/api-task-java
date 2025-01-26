package com.isai.taskrestapi.controller;

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
    public Task findTaskById(@PathVariable Long taksID) {
        return serviceImple.findTaskById(taksID);
    }

    @GetMapping("/findTaskByStatus/{status}")
    public  List<Optional<Task>>  findTaskByStatus(@PathVariable StatusTask status) {
        return serviceImple.findTaskByStatus(status);
    }

    @PostMapping("/saveTask")
    public Task saveTask(@Valid @RequestBody Task task) {
        return serviceImple.saveTask(task);
    }

    @PutMapping("/updateTask/{taksID}")
    public Task updateTask(@PathVariable Long taksID, @Valid @RequestBody Task task) {
        return serviceImple.updateTask(taksID, task);
    }

    @DeleteMapping("/deleteTask/{taksID}")
    public Task deleteTaskById(@PathVariable Long taksID) {
        return serviceImple.deleteTaskById(taksID);
    }


}
