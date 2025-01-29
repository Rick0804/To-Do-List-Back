package com.example.tasklist.controller;

import com.example.tasklist.model.TaskList;
import com.example.tasklist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TaskList")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskList> getAllTask(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskList getTask(@PathVariable long id){
        return taskService.getTask(id);
    }

    @PostMapping
    public void saveTask(@RequestBody TaskList taskList){
        taskService.save(taskList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<taskList> editTask(@PathVariable long id, @RequestBody TaskList taskList){
        try{
            return ResponseEntity.ok(taskList.edit(id, taskList));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
        taskService.edit(taskList);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id, @RequestBody TaskList taskList){

    }

}
