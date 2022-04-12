package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Indexed
@Entity
@Table(name = "FUE_ACTIV_COMERCIAL")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
		allowGetters = true)
public class ActividadeComercial extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_ACTV")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "CAC_DSG")
	@Size(max=50)
	private String cac_dsg;

	@Field
	@Column(name = "CAC")
	@Size(max=2)
	private String cac;


	@Column(name = "ESTADO")
	private float estado = 1;


	//region accessors for public property

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCac_dsg() {
		return cac_dsg;
	}


	public void setCac_dsg(String cac_dsg) {
		this.cac_dsg = cac_dsg;
	}


	public String getCac() {
		return cac;
	}


	public void setCac(String cac) {
		this.cac = cac;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
	
}
