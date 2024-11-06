package com.energias2024.consumos.Servicios;

import com.energias2024.consumos.Entidades.ConsumoDepartamentos;
import com.energias2024.consumos.Repositorios.ConsumoDepartamentosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ConsumoDepartamentosServicio {

    @Autowired
    private ConsumoDepartamentosRepositorio departamentosRepositorio;

    // Método para insertar un nuevo departamento
    public ConsumoDepartamentos insertarDepartamento(ConsumoDepartamentos consumoDepartamentos) {
        return departamentosRepositorio.save(consumoDepartamentos);
    }

    // Método para buscar un departamento por ID
    public Optional<ConsumoDepartamentos> buscarPorId(Integer id) {
        return departamentosRepositorio.findById(id);
    }

    // Método para obtener todos los departamentos
    public List<ConsumoDepartamentos> getAllConsumoDepartamentos() {
        return departamentosRepositorio.findAll();
    }

    // Método para actualizar un departamento por ID
    public ConsumoDepartamentos actualizarDepartamentoPorId(Integer id, ConsumoDepartamentos nuevoDepartamento) {
        return departamentosRepositorio.findById(id).map(departamento -> {
            departamento.setDepartamento(nuevoDepartamento.getDepartamento());
            departamento.setConsumo(nuevoDepartamento.getConsumo());
            departamento.setPoblacion(nuevoDepartamento.getPoblacion());
            return departamentosRepositorio.save(departamento);
        }).orElseThrow(() -> new RuntimeException("Departamento no encontrado con el ID: " + id));
    }
}
