package com.example.tasklist.service;

import com.example.tasklist.model.TaskList;
import com.example.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    };

    public List<TaskList> getTaskList(){
        return taskRepository.findAll();
    };

    public Optional<TaskList> getTask(long id){
        return taskRepository.findById(id);
    }

    public void createTask(TaskList taskList){
        taskRepository.save(taskList);
    }

    public void editTask(long id, TaskList taskList) {
        Optional<TaskList> taskOp = taskRepository.findById(id);

        TaskList task = taskOp.get();
        task.setTaskTitle(taskList.getTaskTitle());
        task.setTaskDescription(taskList.getTaskDescription());
        task.setTaskEnum(taskList.getTaskEnum());

        taskRepository.save(task);
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }


}
