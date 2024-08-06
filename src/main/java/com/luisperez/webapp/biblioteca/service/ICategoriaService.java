package com.luisperez.webapp.biblioteca.service;

import java.util.List;

import com.luisperez.webapp.biblioteca.model.Categoria;

public interface ICategoriaService {

    public List<Categoria> listaCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria buscarCategoriaPorId(Long id);

    public void eliminarCategoria(Categoria categoria);

}
