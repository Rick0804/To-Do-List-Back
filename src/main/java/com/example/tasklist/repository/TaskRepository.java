package com.example.tasklist.repository;

import com.example.tasklist.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskList, Long> {

}
