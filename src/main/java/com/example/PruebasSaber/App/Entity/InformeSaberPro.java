package com.example.PruebasSaber.App.Entity;

import org.springframework.data.mongodb.core.mapping.Document;



import org.springframework.data.annotation.Id;


@Document(collection ="InformesSaberPro")
public class InformeSaberPro {

    @Id
    private String id;

    private String numeroRegistro;

    private int resultadoComunicacion;

    private int resultadoRazonamiento;

    private int resultadoLectura;

    private int resultadoCiudadanas;

    private int resultadoIngles;

    private int resultadoFormulacion;

    private int resultadoPensamiento;

    private int resultadoSoftware;

    private String nivelIngles;

    private int resultadoTotal;

    private String idUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public int getResultadoComunicacion() {
		return resultadoComunicacion;
	}

	public void setResultadoComunicacion(int resultadoComunicacion) {
		this.resultadoComunicacion = resultadoComunicacion;
	}

	public int getResultadoRazonamiento() {
		return resultadoRazonamiento;
	}

	public void setResultadoRazonamiento(int resultadoRazonamiento) {
		this.resultadoRazonamiento = resultadoRazonamiento;
	}

	public int getResultadoLectura() {
		return resultadoLectura;
	}

	public void setResultadoLectura(int resultadoLectura) {
		this.resultadoLectura = resultadoLectura;
	}

	public int getResultadoCiudadanas() {
		return resultadoCiudadanas;
	}

	public void setResultadoCiudadanas(int resultadoCiudadanas) {
		this.resultadoCiudadanas = resultadoCiudadanas;
	}

	public int getResultadoIngles() {
		return resultadoIngles;
	}

	public void setResultadoIngles(int resultadoIngles) {
		this.resultadoIngles = resultadoIngles;
	}

	public int getResultadoFormulacion() {
		return resultadoFormulacion;
	}

	public void setResultadoFormulacion(int resultadoFormulacion) {
		this.resultadoFormulacion = resultadoFormulacion;
	}

	public int getResultadoPensamiento() {
		return resultadoPensamiento;
	}

	public void setResultadoPensamiento(int resultadoPensamiento) {
		this.resultadoPensamiento = resultadoPensamiento;
	}

	public int getResultadoSoftware() {
		return resultadoSoftware;
	}

	public void setResultadoSoftware(int resultadoSoftware) {
		this.resultadoSoftware = resultadoSoftware;
	}

	public String getNivelIngles() {
		return nivelIngles;
	}

	public void setNivelIngles(String nivelIngles) {
		this.nivelIngles = nivelIngles;
	}

	public int getResultadoTotal() {
		return resultadoTotal;
	}

	public void setResultadoTotal(int resultadoTotal) {
		this.resultadoTotal = resultadoTotal;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}


}
