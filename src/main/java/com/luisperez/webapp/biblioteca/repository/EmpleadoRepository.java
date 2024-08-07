package com.luisperez.webapp.biblioteca.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luisperez.webapp.biblioteca.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
