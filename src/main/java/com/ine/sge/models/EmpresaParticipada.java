package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Indexed
@Entity
@Table(name="FUE_EMPPARTICIPADA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmpresaParticipada extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_EMPAR")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "CONTASCONSOL")
	@Size(max=1)
	private String contas_consolidada;

	@Field
	@Column(name = "DATAINTEGRACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_integracao;

	@Column(name = "PERCPARTICIPACAO")
	private float perc_participacao;

	@Field
	@Column(name = "COMENTARIO")
	@Size(max=400)
	private String comentario;

	@Field
	@Column(name = "CLASSNAME")
	@Size(max=50)
	private String classname;

	@Column(name = "ESTADO")
	private float estado = 1;

	//FUE_ENTIDADE$EMPPARTICIPADA
	/*@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "empresa_participada")
	@JsonIgnore
	private Set<Entidade> entidade = new HashSet<>();*/

	//region accessors for public property

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContas_consolidada() {
		return contas_consolidada;
	}

	public void setContas_consolidada(String contas_consolidada) {
		this.contas_consolidada = contas_consolidada;
	}

	public Date getData_integracao() {
		return data_integracao;
	}

	public void setData_integracao(Date data_integracao) {
		this.data_integracao = data_integracao;
	}

	public float getPerc_participacao() {
		return perc_participacao;
	}

	public void setPerc_participacao(float perc_participacao) {
		this.perc_participacao = perc_participacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
