package com.example.tasklist.repository;

import com.example.tasklist.model.GoalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<GoalModel, Long> {

}
