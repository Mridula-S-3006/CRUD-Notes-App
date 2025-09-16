package com.example.notesapp.service;

import com.example.notesapp.model.Note;
import com.example.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // CREATE or UPDATE
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    // READ all
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // READ one by ID
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // DELETE
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
