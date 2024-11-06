package com.energias2024.consumos.Controladores;


import com.energias2024.consumos.Entidades.Usuario;
import com.energias2024.consumos.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/usuarios")

public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioService;

    // Create or update a Usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }


   // Get a Usuario by documento
    @GetMapping("/{documento}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String documento) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(documento);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    // Get all Usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Delete a Usuario by documento
    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String documento) {
        usuarioService.deleteUsuarioById(documento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{documento}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String documento, @RequestBody Usuario usuario) {
        Usuario partialUpdateUsuario = new Usuario();
        if (usuario.getNombre() != null) {
            partialUpdateUsuario.setNombre(usuario.getNombre());
        }
        if (usuario.getApellido() != null) {
            partialUpdateUsuario.setApellido(usuario.getApellido());
        }

        if (usuario.getCiudad() != null) {
            partialUpdateUsuario.setCiudad(usuario.getCiudad());
        }

        if (usuario.getEmail() != null) {
            partialUpdateUsuario.setEmail(usuario.getEmail());
        }
        Usuario updatedUsuario = usuarioService.updateUsuarioByID(documento, partialUpdateUsuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }
}
