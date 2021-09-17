package com.springBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootApp.entity.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

}
