package com.isai.taskrestapi.controller;

import com.isai.taskrestapi.model.Task;
import com.isai.taskrestapi.service.TaskServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImple serviceImple;

    @GetMapping("/getAllTask")
    public List<Task> getAllTask() {
        return serviceImple.getAllTask();
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return serviceImple.saveTask(task);
    }
}
