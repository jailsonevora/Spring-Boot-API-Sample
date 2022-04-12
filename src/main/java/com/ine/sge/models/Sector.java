package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.Size;

@Indexed
@Entity
@Table(name="FUE_SECTOR")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sector extends AuditModel<String> implements Serializable  {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_SECTOR")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "SECTOR_DSG")
	@Size(max=100)
	private String sector_dsg;

	@Field
	@Column(name = "SECTOR")
	@Size(max=5)
	private String sector;

	@Column(name = "ESTADO")
	private float estado = 1;

	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}


	public long getId() {
		return id;
	}


	public String getSector_dsg() {
		return sector_dsg;
	}


	public void setSector_dsg(String sector_dsg) {
		this.sector_dsg = sector_dsg;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
