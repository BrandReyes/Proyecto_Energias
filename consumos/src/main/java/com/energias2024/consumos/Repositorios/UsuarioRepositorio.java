package com.energias2024.consumos.Repositorios;

import com.energias2024.consumos.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    // You can define custom queries here if needed
}
