package com.example.PruebasSaber.App.WebController;

import com.example.PruebasSaber.App.Entity.InformeSaberPro;
import com.example.PruebasSaber.App.Entity.Usuario;
import com.example.PruebasSaber.App.Repository.InformeSaberProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/inform")
public class InformeWebController {


    @Autowired
    private InformeSaberProRepository informeSaberProRepository;


    @GetMapping("/crearInforme/{Id}")
    public String crearInforme(@PathVariable("Id") String Id,Model model) {
        InformeSaberPro informe = new InformeSaberPro();
        informe.setIdUser(Id); // Establece el valor predeterminado de idUser
        model.addAttribute("informe", informe);
        return "crearInforme";
    }

    @GetMapping("/editarInforme/{id}")
    public String editarInforme(@PathVariable("id") String id, Model model) {
        InformeSaberPro  informe = informeSaberProRepository.findByIdUser(id);
        model.addAttribute("informe", informe);
        return "editarInforme";
    }


}
