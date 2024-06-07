package com.example.PruebasSaber.App.Repository;

import com.example.PruebasSaber.App.Entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {

    Usuario findByNumeroDocumento(String numeroDocumento);
}
