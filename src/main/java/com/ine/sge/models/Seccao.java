package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Indexed
@Entity
@Table(name="FUE_SECCAO")
public class Seccao extends AuditModel<String> implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_SECC")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "SECCAO")
	private float seccao;

	@Field
	@Column(name = "AREA")
	private long area;
	
	@Column(name = "ALDEIA")
	private long aldeia;

	@Column(name = "COMUNA")
	private long comuna;


	@Column(name = "MUNICIPIO")
	private long municipio;
	
	
	@Column(name = "PROVINCIA")
	private long provincia;
	
	
	@Column(name = "ESTADO")
	private float estado = 1;

	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}


	public long getId() {
		return id;
	}


	public float getSeccao() {
		return seccao;
	}


	public void setSeccao(float seccao) {
		this.seccao = seccao;
	}


	public long getArea() {
		return area;
	}


	public void setArea(long area) {
		this.area = area;
	}


	public long getAldeia() {
		return aldeia;
	}


	public void setAldeia(long aldeia) {
		this.aldeia = aldeia;
	}


	public long getComuna() {
		return comuna;
	}


	public void setComuna(long comuna) {
		this.comuna = comuna;
	}


	public long getMunicipio() {
		return municipio;
	}


	public void setMunicipio(long municipio) {
		this.municipio = municipio;
	}


	public long getProvincia() {
		return provincia;
	}


	public void setProvincia(long provincia) {
		this.provincia = provincia;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
