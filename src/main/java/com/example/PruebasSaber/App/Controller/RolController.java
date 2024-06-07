package com.example.PruebasSaber.App.Controller;


import com.example.PruebasSaber.App.Entity.Rol;
import com.example.PruebasSaber.App.Entity.Usuario;
import com.example.PruebasSaber.App.Repository.RolRepository;
import com.example.PruebasSaber.App.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rol")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> ListRol() {
        return rolRepository.findAll();
    }

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }
}
