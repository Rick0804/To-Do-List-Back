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
    private TaskEnum goalEnum;

    public GoalModel(String goalTitle, String goalDescription, TaskEnum goalEnum){
        this.goalTitle = goalTitle;
        this.goalDescription = goalDescription;
        this.goalEnum = goalEnum;
    }

    public long getId() {
        return id;
    }

    public TaskEnum getGoalEnum() {
        return goalEnum;
    }

    public void setGoalEnum(TaskEnum GoalEnum) {
        this.goalEnum = GoalEnum;
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
                ", goalEnum=" + goalEnum +
                '}';
    }

}
