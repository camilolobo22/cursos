package com.example.PruebasSaber.App.Service;

import org.springframework.stereotype.Service;

@Service
public class NivelService {
    public String determinarNivel(int resultado) {
        if (resultado <= 300 && resultado >= 191) {
            return "4";
        } else if (resultado <= 190 && resultado >= 156) {
            return "3";
        } else if (resultado <= 155 && resultado >= 126) {
            return "2";
        } else if (resultado <= 125 && resultado >= 0) {
            return "1";
        } else {
            return "Error";
        }
    }
}