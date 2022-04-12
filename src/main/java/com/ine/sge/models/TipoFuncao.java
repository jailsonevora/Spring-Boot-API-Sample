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
@Table(name="FUE_TIPOFUNCAO")
public class TipoFuncao extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_TIPFUN")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "TIPO")
	@Size(max=100)
	private String tipo;
		
	@Column(name = "ESTADO")
	private float estado = 1;

	//region accessors for public property

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTIPO() {
		return tipo;
	}

	public void setTIPO(String tIPO) {
		tipo = tIPO;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
	
}
