package com.energias2024.consumos.Servicios;

import com.energias2024.consumos.Entidades.Usuario;
import com.energias2024.consumos.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioServicio {
    @Autowired
     private UsuarioRepositorio usuarioRepositorio;

    //insert agregar
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }


    //Buscar usuario por documento
    public Optional<Usuario> getUsuarioById(String documento){
        return usuarioRepositorio.findById(documento);
    }

    //Buscar todos los usuarios
    public List<Usuario> getAllUsuarios(){
        return usuarioRepositorio.findAll();
    }

    //Eliminar un usuario
    public void deleteUsuarioById(String documento){
        usuarioRepositorio.deleteById(documento);
    }

    //Actualizar para usuario por id
    public Usuario updateUsuarioByID(String documento, Usuario updateUsuario){
        return usuarioRepositorio.findById(documento).map(existingUsuario ->{


        if (updateUsuario.getNombre() != null) {
            existingUsuario.setNombre(updateUsuario.getNombre());
        }
        if (updateUsuario.getApellido() != null) {
            existingUsuario.setApellido(updateUsuario.getApellido());
        }

        if (updateUsuario.getCiudad() != null) {
            existingUsuario.setCiudad(updateUsuario.getCiudad());
        }

        if (updateUsuario.getEmail() != null) {
            existingUsuario.setEmail(updateUsuario.getEmail());
        }

        //guardar cambios

            return usuarioRepositorio.save(existingUsuario);



        }).orElseThrow(() -> new RuntimeException("Usuario with ID " + documento + " not found"));
    }


}
