package com.example.PruebasSaber.App.WebController;

import com.example.PruebasSaber.App.Entity.InformeSaberPro;
import com.example.PruebasSaber.App.Entity.Usuario;
import com.example.PruebasSaber.App.Repository.InformeSaberProRepository;
import com.example.PruebasSaber.App.Repository.UsuarioRepository;
import com.example.PruebasSaber.App.Service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UsuarioWebController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InformeSaberProRepository informeSaberProRepository;

    @Autowired
    private NivelService nivelService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Usuario> estudiantes = usuarios.stream()
                .filter(usuario -> usuario.getRol().getNombre().equals("Estudiante"))
                .collect(Collectors.toList());
        model.addAttribute("usuarios", estudiantes);
        model.addAttribute("usuario", new Usuario());
        return "ListUsers";
    }

    @GetMapping("/{id}")
    public String mostrarUsuario(@PathVariable("id") String id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        InformeSaberPro informe = informeSaberProRepository.findByIdUser(id);

        model.addAttribute("usuario", usuarioOptional.orElse(null));
        model.addAttribute("informe", informe);
        model.addAttribute("nivelService", nivelService);
        return "UniqueUser";
    }

    @GetMapping("/estudiante/{id}")
    public String mostrarEstudiante(@PathVariable("id") String id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        InformeSaberPro informe = informeSaberProRepository.findByIdUser(id);

        model.addAttribute("usuario", usuarioOptional.orElse(null));
        model.addAttribute("informe", informe);
        model.addAttribute("nivelService", nivelService);
        return "vistaEstudiante";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") String id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        model.addAttribute("usuario", usuarioOptional.orElse(null));
        return "editarUsuario";
    }



}

