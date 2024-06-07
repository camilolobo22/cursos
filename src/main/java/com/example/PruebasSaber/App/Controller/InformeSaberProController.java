package com.example.PruebasSaber.App.Controller;

import com.example.PruebasSaber.App.Entity.InformeSaberPro;
import com.example.PruebasSaber.App.Repository.InformeSaberProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/informepuntaje")
public class InformeSaberProController {

    @Autowired
    private InformeSaberProRepository informeSaberProRepository;

    @GetMapping("/{iduser}")
    public InformeSaberPro ListForUser(@PathVariable("iduser") String IdUser){
        return informeSaberProRepository.findByIdUser(IdUser);
    }

    @PostMapping("/guardarInforme")
    public ResponseEntity<String> guardarInforme(InformeSaberPro informe) {
        informeSaberProRepository.save(informe);
        return ResponseEntity.status(302).header("Location", "/user/"+informe.getIdUser()).body("Informe creado exitosamente");
    }

    @GetMapping("/delete/{Id}")
    public ResponseEntity<String> eliminarInforme(@PathVariable("Id") String Id) {
        informeSaberProRepository.deleteByIdUser(Id);
        return ResponseEntity.status(302).header("Location", "/user/"+Id).body("Informe creado exitosamente");
    }

    @PostMapping("/actualizarInforme")
    public ResponseEntity<String> actualizarProducto(@ModelAttribute InformeSaberPro informe) {
        try {
            InformeSaberPro informeActualizado = informeSaberProRepository.save(informe);
            if (informeActualizado != null) {
                return ResponseEntity.status(302).header("Location", "/user/" + informeActualizado.getIdUser()).body("Informe actualizado exitosamente");
            } else {
                return ResponseEntity.status(404).body("Informe no encontrado");
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que pssueda ocurrir durante la actualización
            return ResponseEntity.status(500).body("Error al actualizar el informe: " + e.getMessage()+"VALOR"+informe.getId());
        }
    }






}
