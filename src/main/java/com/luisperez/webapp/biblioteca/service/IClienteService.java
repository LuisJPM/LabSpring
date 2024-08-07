package com.luisperez.webapp.biblioteca.service;

import java.util.List;

import com.luisperez.webapp.biblioteca.model.Cliente;

public interface IClienteService {

    public List<Cliente> listarCliente();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente buscarClientePorId(Long id);

    public void eliminarCliente(Cliente cliente);

}
