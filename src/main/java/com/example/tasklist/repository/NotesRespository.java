package com.example.tasklist.repository;

import com.example.tasklist.model.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRespository extends JpaRepository<NotesModel, Long> {
}
