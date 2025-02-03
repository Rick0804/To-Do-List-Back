package com.example.tasklist.service;

import com.example.tasklist.model.NotesModel;
import com.example.tasklist.repository.NotesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class NotesService {
    private NotesRespository notesRespository;

    @Autowired
    public NotesService(NotesRespository notesRespository){
           this.notesRespository = notesRespository;
    }

    public List<NotesModel> getAllNoteList(){
        return notesRespository.findAll();
    }

    public Optional<NotesModel> getNote(@PathVariable long id){
        return notesRespository.findById(id);
    }

    public void editTask(@PathVariable long id, NotesModel notesModel){
        Optional<NotesModel> noteOp = notesRespository.findById(id);
        if(!noteOp.isPresent()){
            throw new RuntimeException("ID não encontrado");
        }
        NotesModel note = noteOp.get();
        note.setNoteTitle(notesModel.getNoteTitle());
        note.setNoteDescription(notesModel.getNoteDescription());
    }
}
