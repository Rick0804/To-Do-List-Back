package com.example.tasklist.model;

import com.example.tasklist.enums.TaskEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "goalColumn")
public class GoalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String goalTitle;

    @Column(nullable = false)
    private String goalDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskEnum taskEnum;

    public long getId() {
        return id;
    }

    public TaskEnum getTaskEnum() {
        return taskEnum;
    }

    public void setTaskEnum(TaskEnum taskEnum) {
        this.taskEnum = taskEnum;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    @Override
    public String toString() {
        return "GoalModel{" +
                "id=" + id +
                ", goalTitle='" + goalTitle + '\'' +
                ", goalDescription='" + goalDescription + '\'' +
                ", taskEnum=" + taskEnum +
                '}';
    }

}
