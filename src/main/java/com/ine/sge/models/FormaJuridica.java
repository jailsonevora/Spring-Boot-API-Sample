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
@Table(name="FUE_FORMAJURIDICA")
public class FormaJuridica extends AuditModel<String> implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_FORJURI")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "FORMA_JURIDICA")
	@Size(max=100)
	private String forma_juridica;

	@Field
	@Column(name = "FJR")
	@Size(max=2)
	private String fjr;
	

	@Column(name = "ESTADO")
	private float estado = 1;


	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getForma_juridica() {
		return forma_juridica;
	}


	public void setForma_juridica(String forma_juridica) {
		this.forma_juridica = forma_juridica;
	}


	public String getFjr() {
		return fjr;
	}


	public void setFjr(String fjr) {
		this.fjr = fjr;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
