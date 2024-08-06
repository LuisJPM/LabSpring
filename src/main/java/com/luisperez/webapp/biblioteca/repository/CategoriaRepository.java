package com.luisperez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisperez.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
