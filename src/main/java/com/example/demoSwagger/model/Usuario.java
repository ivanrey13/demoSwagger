package com.example.demoSwagger.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.NonNull;




@Entity
@Table(name="test")
//@ApiModel(description = "Este es el modelo de Usuario")
public class Usuario {

	@Id
	private int id;
	
	@NotNull(message="El campo nombre no puede ser vacio")
	private String name;
	
	@NotNull(message="El campo fecha no puede ser vacio")
	private Date fecha;
	
	//Constructor
	public Usuario() {}


	// Get y Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
}
