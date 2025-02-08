package com.example.tasklist.controller;

import com.example.tasklist.model.NotesModel;
import com.example.tasklist.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping
    public void addTask(@RequestBody NotesModel notesModel){
        notesService.createNote(notesModel);
    }

    @GetMapping
    public List<NotesModel> getAllNotes(){
        return notesService.getNoteList();
    }

    @GetMapping("/{id}")
    public Optional<NotesModel> getNotes(@PathVariable long id){
        return notesService.getNote(id);
    }

    @PutMapping("/{id}")
    public void editNotes(@PathVariable long id, @RequestBody NotesModel notesModel){
        notesService.editNote(id, notesModel);
    }

    @DeleteMapping("/{id}")
    public void deleteNotes(@PathVariable long id){
        notesService.deleteNote(id);
    }
}
