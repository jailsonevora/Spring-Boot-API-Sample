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
import javax.validation.constraints.Size;

@Indexed
@Entity
@Table(name="FUE_CONTABILIDADE")
public class Contabilidade extends AuditModel<String> implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CONTB")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "CNTA_DSG")
	@Size(max=50)
	private String cnta_dsg;

	@Field
	@Column(name = "CNTA")
	@Size(max=4)
	private String cnta;
	
	@Column(name = "ESTADO")
	private float estado = 1;


	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getCnta_dsg() {
		return cnta_dsg;
	}

	public void setCnta_dsg(String cnta_dsg) {
		this.cnta_dsg = cnta_dsg;
	}

	public String getCnta() {
		return cnta;
	}

	public void setCnta(String cnta) {
		this.cnta = cnta;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
