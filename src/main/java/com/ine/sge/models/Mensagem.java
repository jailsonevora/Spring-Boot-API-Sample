package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Indexed
@Entity
@Table(name="FUE_MENSAGEM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mensagem extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_MENSAGEM")
	private long id;

	@Field
	@Column(name = "REMETENTE")
	@Size(max=200)
	private String remetente;

	@Field
	@Column(name = "DESTINATARIO")
	@Size(max=200)
	private String destinatario;

	@Field
	@Column(name = "TITULO")
	@Size(max=400)
	private String titulo;

	@Field
	@Lob
	@Column(name = "CORPO_MENSAGEM")
	private String corpomensagem;

	@Column(name = "ESTADO")
	private float estado = 1;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ENTIDADE", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	//@JsonIgnore
	private Entidade entidade;

	//region accessors for public property

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpomensagem() {
		return corpomensagem;
	}

	public void setCorpomensagem(String corpomensagem) {
		this.corpomensagem = corpomensagem;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}

	//endregion
}
