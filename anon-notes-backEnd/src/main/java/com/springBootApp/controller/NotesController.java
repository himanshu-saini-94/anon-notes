package com.springBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootApp.entity.Note;
import com.springBootApp.repository.NotesRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotesController {
	
	@Autowired
	NotesRepository nRepo;

	@GetMapping("/notes")
	public ResponseEntity<List<Note>> readNotes() {
		return new ResponseEntity<List<Note>>(nRepo.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		 return new ResponseEntity<Note>(nRepo.save(note),HttpStatus.CREATED);
	}
	
	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> readNote (@PathVariable Long id) {
		return new ResponseEntity<Note>(nRepo.findById(id).get(), HttpStatus.OK);
	}
}
