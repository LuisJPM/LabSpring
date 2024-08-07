package com.luisperez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisperez.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
 
}