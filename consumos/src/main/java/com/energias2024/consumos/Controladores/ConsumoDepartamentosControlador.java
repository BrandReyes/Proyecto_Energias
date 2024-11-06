package com.energias2024.consumos.Controladores;

import com.energias2024.consumos.Entidades.ConsumoDepartamentos;
import com.energias2024.consumos.Servicios.ConsumoDepartamentosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/departamentos")

public class ConsumoDepartamentosControlador {

    @Autowired
    private ConsumoDepartamentosServicio servicio;

    // Endpoint para agregar un nuevo departamento
    @PostMapping("/agregar")
    public ResponseEntity<ConsumoDepartamentos> agregarDepartamento(@RequestBody ConsumoDepartamentos consumoDepartamentos) {
        ConsumoDepartamentos nuevoDepartamento = servicio.insertarDepartamento(consumoDepartamentos);
        return new ResponseEntity<>(nuevoDepartamento, HttpStatus.CREATED);
    }

    // Endpoint para buscar un departamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsumoDepartamentos> buscarPorId(@PathVariable Integer id) {
        Optional<ConsumoDepartamentos> departamento = servicio.buscarPorId(id);
        return departamento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint para obtener todos los departamentos
    @GetMapping
    public ResponseEntity<List<ConsumoDepartamentos>> getAllConsumoDepartamentos() {
        List<ConsumoDepartamentos> ConsumoDepartamentos = servicio.getAllConsumoDepartamentos();
        return ResponseEntity.ok(ConsumoDepartamentos);
    }

    // Endpoint para actualizar un departamento por ID
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ConsumoDepartamentos> actualizarDepartamento(@PathVariable Integer id,
                                                                      @RequestBody ConsumoDepartamentos nuevoDepartamento) {
        try {
            ConsumoDepartamentos departamentoActualizado = servicio.actualizarDepartamentoPorId(id, nuevoDepartamento);
            return ResponseEntity.ok(departamentoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
