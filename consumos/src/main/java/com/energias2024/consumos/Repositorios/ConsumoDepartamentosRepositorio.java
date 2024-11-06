package com.energias2024.consumos.Repositorios;

import com.energias2024.consumos.Entidades.ConsumoDepartamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConsumoDepartamentosRepositorio extends JpaRepository<ConsumoDepartamentos, Integer> {
}
