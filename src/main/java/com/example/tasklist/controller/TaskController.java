package com.example.tasklist.controller;

import com.example.tasklist.model.TaskList;
import com.example.tasklist.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/TaskList")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public void addTask(@RequestBody TaskList taskList){
        taskService.createTask(taskList);
    }

    @GetMapping
    public List<TaskList> getAllTask(){
        return taskService.getTaskList();
    }

    @GetMapping("/{id}")
    public Optional<TaskList> getTask(@PathVariable long id){
        return taskService.getTask(id);
    }

    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody TaskList taskList){
        taskService.editTask(id, taskList);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
    }

}
