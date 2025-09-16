package com.example.notesapp.controller;

import com.example.notesapp.model.Note;
import com.example.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*") // Allow frontend JS to call API
public class NoteController {

    @Autowired
    private NoteService noteService;

    // CREATE
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    // READ all
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // READ one
    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id); // ensure correct ID
        return noteService.saveNote(note);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return "Note deleted";
    }
}
