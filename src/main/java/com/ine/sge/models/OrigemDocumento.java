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
@Table(name="FUE_ORIGEM_DOC")
public class OrigemDocumento extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_ORGDOC")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "ORIGEM")
	@Size(max=2)
	private String origem;

	@Field
	@Column(name = "ORIGEM_DSG")
	@Size(max=50)
	private String origem_dsg;
	

	@Column(name = "ESTADO")
	private float estado = 1;


	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getOrigem_dsg() {
		return origem_dsg;
	}


	public void setOrigem_dsg(String origem_dsg) {
		this.origem_dsg = origem_dsg;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
