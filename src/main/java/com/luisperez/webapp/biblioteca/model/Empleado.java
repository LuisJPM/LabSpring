package com.luisperez.webapp.biblioteca.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;


@Entity 
@Data
@Table(name = "Empleados") 
public class Empleado {
        @Id
        private Long dpi;
        private String nombre;
        private String apellido;
        private String telefono;
        private String direccion;
        
}
