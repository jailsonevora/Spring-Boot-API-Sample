package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="FUE_CAE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CAE extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CAE")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "CAE")
	@Size(max=5)
	private String cae;

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

	//FUE_ESTABELECIMENTO$CAE_SEC
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "cae")
	@JsonIgnore
	private Set<Estabelecimento> estabelecimento = new HashSet<>();

	//FUE_ENTIDADE$CAE_SEC
	/*@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					//CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "cae")
	@JsonIgnore
	private Set<Entidade> entidade = new HashSet<>();*/

	//region accessors for public property

	public Set <Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Set <Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	/*public Set <Entidade> getEntidade() {
		return entidade;
	}

	public void setEntidade(Set <Entidade> entidade) {
		this.entidade = entidade;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCae() {
		return cae;
	}

	public void setCae(String cae) {
		this.cae = cae;
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

	//endregion
}
