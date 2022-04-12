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
@Table(name="FUE_SITUACAO")
public class Situacao extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_SITUA")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "STA_DSG")
	@Size(max=50)
	private String designacao;

	@Field
	@Column(name = "STA")
	@Size(max=2)
	private String sta;

	@Column(name = "ESTADO")
	private float estado = 1;

	//region accessors for public property
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
