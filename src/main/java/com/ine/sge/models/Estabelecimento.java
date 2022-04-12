package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Indexed
@Entity
@Table(name="FUE_ESTABELECIMENTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estabelecimento extends AuditModel<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_ESTABELE")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "DATA_CONSTITUICAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_constituicao;

	@Column(name = "ESTADO")
	private float estado = 1;

	@Field
	@Column(name = "NUM_FUNCIONARIO")
	private float num_func;

	@Field
	@Column(name = "NUM_FUNCIONARIO_HOMEM")
	private float num_func_homem;

	@Field
	@Column(name = "NUM_FUNCIONARIO_MULHER")
	private float num_func_mulher;

	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "CONTACTO", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Contacto contacto;

	@Field
	@Column(name = "SEDE")
	private Boolean sede;

	@Field
	@Column(name = "CLASSNAME")
	@Size(max=50)
	private String classname;

	@Field
	@Column(name = "num_estabele")
	@Size(max=12)
	private String num_estabelecimento;

	@Field
	@Column(name = "DESCOUTRAS")
	@Size(max=100)
	private String decoutras;

	@Field
	@Column(name = "LATITUDE")
	@Size(max=100)
	private String latitude;

	@Field
	@Column(name = "LONGITUDE")
	@Size(max=100)
	private String longitude;

	@Field
	@Column(name = "COMENTARIOESTAB")
	@Size(max=400)
	private String comentarios;

	@Column(name = "SITUACAO_EMPRESA")
	private long situacao_empresa;

	@Field
	@Column(name = "VOLUME_VENDAS")
	private float volume_vendas;

	@Column(name = "ACTI_ECO_PRINCIPAL")
	private long acti_eco_principal;

	@Field
	@Column(name = "NOME")
	@Size(max=120)
	private String nome;

	@Field
	@Column(name = "DATACRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_criacao;

	@Field
	@Column(name = "DATA_DOCUMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_documento;

	@Field
	@Column(name = "DATASITUACAOACTIVIDADE")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_situacao_atividade;

	@Field
	@Column(name = "DATAULTIMAINSERCAO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_ultima_insercao;

	//@Field
	@Column(name = "NUM_FUNC_REM")
	private float num_func_rem;

	//@Field
	@Column(name = "NUM_FUNC_HOMEM_REM")
	private float num_func_homem_rem;

	//@Field
	@Column(name = "NUM_FUNC_MULHER_REM")
	private float num_func_mulher_rem;

	//@Field
	@Column(name = "NUM_FUNC_NREM")
	private float num_func_nrem;

	//@Field
	@Column(name = "NUM_FUNC_HOMEM_NREM")
	private float num_func_homem_nrem;

	//@Field
	@Column(name = "NUM_FUNC_MULHER_NREM")
	private float num_func_mulher_nrem;

	//@Field
	@Column(name = "NUM_FUNC_NAC")
	private float num_func_nac;

	//@Field
	@Column(name = "NUM_FUNC_EST")
	private float num_func_est;

	//@Field
	@Column(name = "NUM_FUNCIONARIO_H_NAC")
	private float num_funcionario_h_nac;

	//@Field
	@Column(name = "NUM_FUNCIONARIO_H_EST")
	private float num_funcionario_h_est;

	//@Field
	@Column(name = "NUM_FUNCIONARIO_M_NAC")
	private float num_funcionario_m_nac;

	//@Field
	@Column(name = "NUM_FUNCIONARIO_M_EST")
	private float num_funcionario_m_est;

	//@Field
	@Column(name = "NUM_FUNC_REM_NAC")
	private float num_func_rem_nac;

	//@Field
	@Column(name = "NUM_FUNC_REM_EST")
	private float num_func_rem_est;

	//@Field
	@Column(name = "NUM_FUNC_H_REM_NAC")
	private float num_func_h_rem_nac;

	//@Field
	@Column(name = "NUM_FUNC_H_REM_EST")
	private float num_func_h_rem_est;

	//@Field
	@Column(name = "NUM_FUNC_M_REM_NAC")
	private float num_func_m_rem_nac;

	//@Field
	@Column(name = "NUM_FUNC_M_REM_EST")
	private float num_func_m_rem_est;

	//@Field
	@Column(name = "NUM_FUNC_NREM_NAC")
	private float num_func_nrem_nac;

	//@Field
	@Column(name = "NUM_FUNC_NREM_EST")
	private float num_func_nrem_est;

	//@Field
	@Column(name = "NUM_FUNC_H_NREM_NAC")
	private float num_func_h_nrem_nac;

	//@Field
	@Column(name = "NUM_FUNC_H_NREM_EST")
	private float num_func_h_nrem_est;

	//@Field
	@Column(name = "NUM_FUNC_M_NREM_NAC")
	private float num_func_m_nrem_nac;

	//@Field
	@Column(name = "NUM_FUNC_M_NREM_EST")
	private float num_func_m_nrem_est;

	//FUE_ESTABELECIMENTO$CAE_SEC
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "FUE_ESTABELECIMENTO$CAE_SEC",
			joinColumns = { @JoinColumn(name = "ID_ESTABELE") },
			inverseJoinColumns = { @JoinColumn(name = "ID_CAE") })
	//@JsonIgnore
	private Set<CAE> cae = new HashSet<>();

	//FUE_ENTIDADE$ESTABELECIMENTOS
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "estabelecimento")
	@JsonIgnore
	private Set<Entidade> entidade = new HashSet<>();

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTIDADE", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	//@JsonIgnore
	private Entidade entidade;*/


	//region accessors for public property

	public long getActi_eco_principal() {
		return acti_eco_principal;
	}

	public void setActi_eco_principal(long acti_eco_principal) {
		this.acti_eco_principal = acti_eco_principal;
	}

	public Set <Entidade> getEntidade() {
		return entidade;
	}

	public void setEntidade(Set <Entidade> entidade) {
		this.entidade = entidade;
	}

	public Set <CAE> getCae() {
		return cae;
	}

	public void setCae(Set <CAE> cae) {
		this.cae = cae;
	}

	public float getVolume_vendas() {
		return volume_vendas;
	}

	public void setVolume_vendas(float volume_vendas) {
		this.volume_vendas = volume_vendas;
	}

	public long getSituacao_empresa() {
		return situacao_empresa;
	}

	public void setSituacao_empresa(long situacao_empresa) {
		this.situacao_empresa = situacao_empresa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData_constituicao() {
		return data_constituicao;
	}

	public void setData_constituicao(Date data_constituicao) {
		this.data_constituicao = data_constituicao;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}

	public float getNum_func() {
		return num_func;
	}

	public void setNum_func(float num_func) {
		this.num_func = num_func;
	}

	public float getNum_func_homem() {
		return num_func_homem;
	}

	public void setNum_func_homem(float num_func_homem) {
		this.num_func_homem = num_func_homem;
	}

	public float getNum_func_mulher() {
		return num_func_mulher;
	}

	public void setNum_func_mulher(float num_func_mulher) {
		this.num_func_mulher = num_func_mulher;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Boolean getSede() {
		return sede;
	}

	public void setSede(Boolean sede) {
		this.sede = sede;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getNum_estabelecimento() {
		return num_estabelecimento;
	}

	public void setNum_estabelecimento(String num_estabelecimento) {
		this.num_estabelecimento = num_estabelecimento;
	}

	public String getDecoutras() {
		return decoutras;
	}

	public void setDecoutras(String decoutras) {
		this.decoutras = decoutras;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_documento() {
		return data_documento;
	}

	public void setData_documento(Date data_documento) {
		this.data_documento = data_documento;
	}

	public Date getData_situacao_atividade() {
		return data_situacao_atividade;
	}

	public void setData_situacao_atividade(Date data_situacao_atividade) {
		this.data_situacao_atividade = data_situacao_atividade;
	}

	public Date getData_ultima_insercao() {
		return data_ultima_insercao;
	}

	public void setData_ultima_insercao(Date data_ultima_insercao) {
		this.data_ultima_insercao = data_ultima_insercao;
	}

	public float getNum_func_rem() {
		return num_func_rem;
	}

	public void setNum_func_rem(float num_func_rem) {
		this.num_func_rem = num_func_rem;
	}

	public float getNum_func_homem_rem() {
		return num_func_homem_rem;
	}

	public void setNum_func_homem_rem(float num_func_homem_rem) {
		this.num_func_homem_rem = num_func_homem_rem;
	}

	public float getNum_func_mulher_rem() {
		return num_func_mulher_rem;
	}

	public void setNum_func_mulher_rem(float num_func_mulher_rem) {
		this.num_func_mulher_rem = num_func_mulher_rem;
	}

	public float getNum_func_nrem() {
		return num_func_nrem;
	}

	public void setNum_func_nrem(float num_func_nrem) {
		this.num_func_nrem = num_func_nrem;
	}

	public float getNum_func_homem_nrem() {
		return num_func_homem_nrem;
	}

	public void setNum_func_homem_nrem(float num_func_homem_nrem) {
		this.num_func_homem_nrem = num_func_homem_nrem;
	}

	public float getNum_func_mulher_nrem() {
		return num_func_mulher_nrem;
	}

	public void setNum_func_mulher_nrem(float num_func_mulher_nrem) {
		this.num_func_mulher_nrem = num_func_mulher_nrem;
	}

	public float getNum_func_nac() {
		return num_func_nac;
	}

	public void setNum_func_nac(float num_func_nac) {
		this.num_func_nac = num_func_nac;
	}

	public float getNum_func_est() {
		return num_func_est;
	}

	public void setNum_func_est(float num_func_est) {
		this.num_func_est = num_func_est;
	}

	public float getNum_funcionario_h_nac() {
		return num_funcionario_h_nac;
	}

	public void setNum_funcionario_h_nac(float num_funcionario_h_nac) {
		this.num_funcionario_h_nac = num_funcionario_h_nac;
	}

	public float getNum_funcionario_h_est() {
		return num_funcionario_h_est;
	}

	public void setNum_funcionario_h_est(float num_funcionario_h_est) {
		this.num_funcionario_h_est = num_funcionario_h_est;
	}

	public float getNum_funcionario_m_nac() {
		return num_funcionario_m_nac;
	}

	public void setNum_funcionario_m_nac(float num_funcionario_m_nac) {
		this.num_funcionario_m_nac = num_funcionario_m_nac;
	}

	public float getNum_funcionario_m_est() {
		return num_funcionario_m_est;
	}

	public void setNum_funcionario_m_est(float num_funcionario_m_est) {
		this.num_funcionario_m_est = num_funcionario_m_est;
	}

	public float getNum_func_rem_nac() {
		return num_func_rem_nac;
	}

	public void setNum_func_rem_nac(float num_func_rem_nac) {
		this.num_func_rem_nac = num_func_rem_nac;
	}

	public float getNum_func_rem_est() {
		return num_func_rem_est;
	}

	public void setNum_func_rem_est(float num_func_rem_est) {
		this.num_func_rem_est = num_func_rem_est;
	}

	public float getNum_func_h_rem_nac() {
		return num_func_h_rem_nac;
	}

	public void setNum_func_h_rem_nac(float num_func_h_rem_nac) {
		this.num_func_h_rem_nac = num_func_h_rem_nac;
	}

	public float getNum_func_h_rem_est() {
		return num_func_h_rem_est;
	}

	public void setNum_func_h_rem_est(float num_func_h_rem_est) {
		this.num_func_h_rem_est = num_func_h_rem_est;
	}

	public float getNum_func_m_rem_nac() {
		return num_func_m_rem_nac;
	}

	public void setNum_func_m_rem_nac(float num_func_m_rem_nac) {
		this.num_func_m_rem_nac = num_func_m_rem_nac;
	}

	public float getNum_func_m_rem_est() {
		return num_func_m_rem_est;
	}

	public void setNum_func_m_rem_est(float num_func_m_rem_est) {
		this.num_func_m_rem_est = num_func_m_rem_est;
	}

	public float getNum_func_nrem_nac() {
		return num_func_nrem_nac;
	}

	public void setNum_func_nrem_nac(float num_func_nrem_nac) {
		this.num_func_nrem_nac = num_func_nrem_nac;
	}

	public float getNum_func_nrem_est() {
		return num_func_nrem_est;
	}

	public void setNum_func_nrem_est(float num_func_nrem_est) {
		this.num_func_nrem_est = num_func_nrem_est;
	}

	public float getNum_func_h_nrem_nac() {
		return num_func_h_nrem_nac;
	}

	public void setNum_func_h_nrem_nac(float num_func_h_nrem_nac) {
		this.num_func_h_nrem_nac = num_func_h_nrem_nac;
	}

	public float getNum_func_h_nrem_est() {
		return num_func_h_nrem_est;
	}

	public void setNum_func_h_nrem_est(float num_func_h_nrem_est) {
		this.num_func_h_nrem_est = num_func_h_nrem_est;
	}

	public float getNum_func_m_nrem_nac() {
		return num_func_m_nrem_nac;
	}

	public void setNum_func_m_nrem_nac(float num_func_m_nrem_nac) {
		this.num_func_m_nrem_nac = num_func_m_nrem_nac;
	}

	public float getNum_func_m_nrem_est() {
		return num_func_m_nrem_est;
	}

	public void setNum_func_m_nrem_est(float num_func_m_nrem_est) {
		this.num_func_m_nrem_est = num_func_m_nrem_est;
	}
	//endregion

}
