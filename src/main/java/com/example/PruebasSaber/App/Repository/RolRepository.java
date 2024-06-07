package com.example.PruebasSaber.App.Repository;

import com.example.PruebasSaber.App.Entity.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepository extends MongoRepository<Rol,String> {
}
