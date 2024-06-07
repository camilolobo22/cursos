package com.example.PruebasSaber.App.Controller;

import com.example.PruebasSaber.App.Entity.InformeSaberPro;
import com.example.PruebasSaber.App.Entity.Rol;
import com.example.PruebasSaber.App.Entity.Usuario;
import com.example.PruebasSaber.App.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioService;

    @GetMapping
    public List<Usuario> ListUsers() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> UniqueUser(@PathVariable("id") String id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/students")
    public Usuario crearUsuarioStudent(@RequestBody Usuario usuario) {
        usuario.setRol(new Rol("66296c28329f9b6fbca76046","Estudiante"));
        return usuarioService.save(usuario);
    }

    @PostMapping("/coordinador")
    public Usuario crearUsuarioAdmin(@RequestBody Usuario usuario) {
        usuario.setRol(new Rol("66296186329f9b6fbca76045","Coordinador"));
        return usuarioService.save(usuario);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@ModelAttribute Usuario usuario) {
        usuario.setRol(new Rol("66296c28329f9b6fbca76046","Estudiante"));
        try {
            Usuario usuarioActualizado = usuarioService.save(usuario);
            if (usuarioActualizado != null) {
                return ResponseEntity.status(302).header("Location", "/user/listar").body("Usuario actualizado exitosamente");
            } else {
                return ResponseEntity.status(404).body("Usuario no encontrado");
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que pssueda ocurrir durante la actualización
            return ResponseEntity.status(500).body("Error al actualizar el informe: " + e.getMessage()+"VALOR"+usuario.getId());
        }
    }


    @GetMapping("/delete/{Id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String Id) {
        usuarioService.deleteById(Id);
        return ResponseEntity.status(302).header("Location", "/user/listar").body("Usuario eliminado exitosamente");
    }

}