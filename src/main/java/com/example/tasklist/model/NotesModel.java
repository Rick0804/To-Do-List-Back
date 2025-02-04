package com.example.tasklist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Notes")
public class NotesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String noteTitle;

    @Column(nullable = false)
    private String noteDescription;

    public NotesModel() {

    }

    public NotesModel(String noteTitle, String noteDescription){
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

}
