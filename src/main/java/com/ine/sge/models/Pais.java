package com.ine.sge.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Indexed
@Entity
@Table(name="FUE_PAIS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pais extends AuditModel<String> implements Serializable{

	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_PAIS")
	//@JsonIgnore
	private long id;


	@Column(name = "PAIS")
	private String pais;

	@Column(name = "ESTADO")
	private float estado = 1;

	/*@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "pais")
	@JsonIgnore
    private Set<Provincia> provincia = new HashSet<>();*/

	//region accessors for public property
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}

	/*
	public Set<Provincia> getProvincia() {
			return provincia;
		}


	public void setProvincia(Set<Provincia> provincia) {
		this.provincia = provincia;
	}*/
	//endregion
}
