package com.luisperez.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisperez.webapp.biblioteca.model.Empleado;
import com.luisperez.webapp.biblioteca.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override

    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
       return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscarEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);

    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.delete (empleado);
    }

    public EmpleadoRepository getEmpleadoRepository() {
        return empleadoRepository;
    }

    public void setEmpleadoRepository(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
   
}
