package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Indexed
@Entity
@Table(name="FUE_CANAL")
public class Canal extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CANAL")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "CANAL")
	@Size(max=50)
	private String canal;

	@Column(name = "ESTADO")
	private float estado = 1;


	//region accessors for public property

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}

	//endregion

}
