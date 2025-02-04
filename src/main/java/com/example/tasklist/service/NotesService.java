package com.example.tasklist.service;

import com.example.tasklist.model.NotesModel;
import com.example.tasklist.repository.NotesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {
    private final NotesRespository notesRespository;

    @Autowired
    public NotesService(NotesRespository notesRespository){
           this.notesRespository = notesRespository;
    }

    public List<NotesModel> getNoteList(){
        return notesRespository.findAll();
    }

    public Optional<NotesModel> getNote(long id){
        return notesRespository.findById(id);
    }

    public void createNote(NotesModel notesModel){
       notesRespository.save(notesModel);
    }

    public void editNote(long id, NotesModel notesModel){
        Optional<NotesModel> noteOp = notesRespository.findById(id);
        if(!noteOp.isPresent()){
            throw new RuntimeException("ID não encontrado");
        }
        NotesModel note = noteOp.get();
        note.setNoteTitle(notesModel.getNoteTitle());
        note.setNoteDescription(notesModel.getNoteDescription());
        notesRespository.save(note);
    }

    public void deleteNote(long id){
        notesRespository.deleteById(id);
    }

}
