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
@RequestMapping("/TaskList")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskList> getAllTask(){
        return taskService.getTaskList();
    }

    @GetMapping("/{id}")
    public Optional<TaskList> getTask(@PathVariable long id){
        return taskService.getTask(id);
    }

    @PostMapping
    public void saveTask(@RequestBody TaskList taskList){
        taskService.createTask(taskList);
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
