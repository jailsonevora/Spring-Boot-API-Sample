package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Indexed
@Entity
@Table(name="FUE_CLASSIFICACAO")
public class Classificacao extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CLASS")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "CLASSIFICACAO")
	@Size(max=5)
	private String clasificacao;

	@Field
	@Column(name = "DESIGNACAO")
	@Size(max=200)
	private String designacao;

	@Field
	@Column(name = "CLASSNAME")
	@Size(max=50)
	private String classname;

	@Column(name = "ESTADO")
	private float estado = 1;


	//FUE_CLASSIFICACAO$NIVEIS
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "FUE_CLASSIFICACAO$NIVEIS",
			joinColumns = { @JoinColumn(name = "ID_CLASS") },
			inverseJoinColumns = { @JoinColumn(name = "ID_NIVEL") })
	@JsonIgnore
	private Set<Nivel> niveis = new HashSet<>();


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClasificacao() {
		return clasificacao;
	}

	public void setClasificacao(String clasificacao) {
		this.clasificacao = clasificacao;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}

	public Set <Nivel> getNiveis() {
		return niveis;
	}

	public void setNiveis(Set <Nivel> niveis) {
		this.niveis = niveis;
	}
}
