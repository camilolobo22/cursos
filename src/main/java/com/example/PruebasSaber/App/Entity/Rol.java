package com.example.PruebasSaber.App.Entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Roles")
public class Rol {

    @Id
    private String id;

    private String nombre;

    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
}
