package com.example.tasklist.model;

import com.example.tasklist.enums.TaskEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "taskList")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private String taskDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskEnum taskEnum;

    public TaskList(){

    }

    public TaskList(String taskTitle, String taskDescription, TaskEnum taskEnum){
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskEnum = taskEnum;
    }

    public long getId() {
        return this.id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskEnum getTaskEnum() {
        return taskEnum;
    }

    public void setTaskEnum(TaskEnum taskEnum) {
        this.taskEnum = taskEnum;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", price=" + taskDescription +
                ", taskEnum=" + taskEnum +
                '}';
    }


}
