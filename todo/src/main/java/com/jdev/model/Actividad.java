package com.jdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actividades")
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column	(name = "id",updatable=false,nullable=false)
	private Integer id;
	
	@Column	(name = "detalle")
	private String 	detalle;
	
	@Column (name = "estado")
	private Integer estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}
