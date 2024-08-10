package com.luisperez.webapp.biblioteca.controller;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luisperez.webapp.biblioteca.model.Empleado;
import com.luisperez.webapp.biblioteca.model.Libro;
import com.luisperez.webapp.biblioteca.service.EmpleadoService;

@Controller
@RestController
@RequestMapping("")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        try {
            return ResponseEntity.ok(empleadoService.listarEmpleado());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<Map<String,String>> agregarEmpleado(@RequestBody Empleado empleado){
        Map<String,String> response = new HashMap<>();
        try {
            empleadoService.guardarEmpleado(empleado);
            response.put("message", "Empleado encontrado con exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("message", "no se pudo crear");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/empleado")
    public ResponseEntity<Empleado> buscarEmpleado(@RequestParam Long id){
        try{
            return ResponseEntity.ok(empleadoService.buscarEmpleadoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/empleado")
    public ResponseEntity<Map<String, String>> editarEmpleado(@RequestParam Long id, @RequestBody Empleado empleadoNuevo){
        Map<String, String> response = new HashMap<>();
        
        try {
            Empleado empleadoViejo = empleadoService.buscarEmpleadoPorId(id);
            empleadoViejo.setNombre(empleadoNuevo.getNombre());
            empleadoViejo.setApellido(empleadoNuevo.getApellido());
            empleadoViejo.setTelefono(empleadoNuevo.getTelefono());
            empleadoViejo.setDireccion(empleadoNuevo.getDireccion());
            empleadoViejo.setDpi(empleadoNuevo.getDpi());
            empleadoService.guardarEmpleado(empleadoNuevo);
            response.put("message", "modificao");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "no se pudo modificar");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/empleado")
    public ResponseEntity<Map<String, String>> eliminarEmpleado(@RequestParam Long id){
        Map<String, String> response = new HashMap<>();
        
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("message", "eliminao");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "no se pudo eliminar");
            return ResponseEntity.badRequest().body(response);
        }
    }
}