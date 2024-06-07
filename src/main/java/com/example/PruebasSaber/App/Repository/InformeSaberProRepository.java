package com.example.PruebasSaber.App.Repository;

import com.example.PruebasSaber.App.Entity.InformeSaberPro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface InformeSaberProRepository extends MongoRepository<InformeSaberPro, String> {
    InformeSaberPro findByIdUser(String idUser);
     void deleteByIdUser(String idUser);
}
