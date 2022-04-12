package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Indexed
@Entity
@Table(name="FUE_NIVEL")
public class Nivel extends AuditModel<String> implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_NIVEL")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "DIVISAO")
	@Size(max=200)
	private String divisao;

	@Field
	@Column(name = "GRUPO")
	@Size(max=200)
	private String grupo;

	@Field
	@Column(name = "CLASSE")
	@Size(max=200)
	private String classe;

	@Field
	@Column(name = "SUBCLASSE")
	@Size(max=200)
	private String subclasse;

	@Field
	@Column(name = "CATEGORIA")
	@Size(max=200)
	private String categoria;

	@Field
	@Column(name = "SUBCATEGORIA")
	@Size(max=200)
	private String subcategoria;

	@Field
	@Column(name = "POSICAO")
	@Size(max=50)
	private String posicao;
	
	@Column(name = "ESTADO")
	private float estado = 1;

	//FUE_CLASSIFICACAO$NIVEIS
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "niveis")
	@JsonIgnore
	private Set<Classificacao> classificacoes = new HashSet<>();

	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}

	public Set <Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(Set <Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	public long getId() {
		return id;
	}

	public String getDivisao() {
		return divisao;
	}

	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSubclasse() {
		return subclasse;
	}

	public void setSubclasse(String subclasse) {
		this.subclasse = subclasse;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
