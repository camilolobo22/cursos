package com.example.PruebasSaber.App.WebController;

import com.example.PruebasSaber.App.Entity.Usuario;
import com.example.PruebasSaber.App.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        return "Login";
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        return "catalogo";
    }
    
    @GetMapping("/pagos")
    public String pagos(Model model) {
        return "pagos";
    }
    
    @GetMapping("/preguntas")
    public String preguntas(Model model) {
        return "preguntas";
    }
    
    @GetMapping("/privacidad")
    public String privacidad(Model model) {
        return "privacidad";
    }
    
    @GetMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }
    
    
    @PostMapping("/login")
    public String login(@RequestParam("numeroDocumento") String numeroDocumento,
                        @RequestParam("password") String password,
                        Model model) {
        // Buscar al usuario por el número de documento
        Usuario usuario = usuarioRepository.findByNumeroDocumento(numeroDocumento);

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Redireccionar según el rol del usuario
            if (usuario.getRol().getNombre().equals("Estudiante")) {

                return "redirect:/user/estudiante/"+usuario.getId();
            } else if (usuario.getRol().getNombre().equals("Coordinador")) {

                return "redirect:/user/listar";
            } else {

                return "redirect:/";
            }
        }else{
                model.addAttribute("error", "Credenciales incorrectas");
                return "login";
            }
        }
    }
