package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="FUE_SOCIO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Socio extends AuditModel<String> implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_SOCIO")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "NUMERO")
	private float numero;

	@Field
	@Column(name = "NOME")
	@Size(max=100)
	private String nome;
	
	@Column(name = "ESTADO")
	private float estado = 1;

	//FUE_ENTIDADE$SOCIOS
	/*@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "socio")
	@JsonIgnore
	private Set<Entidade> entidade = new HashSet<>();*/

	//region accessors for public property

	public void setId(long id) {
		this.id = id;
	}

	/*public Set <Entidade> getEntidade() {
		return entidade;
	}

	public void setEntidade(Set <Entidade> entidade) {
		this.entidade = entidade;
	}
*/
	public long getId() {
		return id;
	}

	public float getNumero() {
		return numero;
	}

	public void setNumero(float numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
