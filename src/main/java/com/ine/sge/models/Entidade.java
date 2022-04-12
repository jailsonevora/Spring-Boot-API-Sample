package com.ine.sge.models;




import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name="FUE_ENTIDADE")
public class Entidade extends AuditModel<String> implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_ENTIDADE", updatable = false, nullable = false)
	//@JsonIgnore
	private long id;

	@NaturalId
	//@NotEmpty
	//@NotNull
	@Field
	@Column(name = "NATURAL_ID")
	private String naturalId;

	@Field
	@Column(name = "NOME")
	@Size(min = 1, max = 400)
	private String nome;

	@Field
	@Column(name = "ABREVIATURA")
	@Size(min = 1, max = 400)
	private String abreviatura;


	// region OneToOne

	/*@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL)
    @JoinColumn(name = "TITULO_ACADEMICO", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
	private TituloAcademico titulo_academico;*/

	/*@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "SECTOR", nullable = false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
	private Sector sector;*/

	@Column(name = "SECTOR")
	private float sector;

	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "CONTACTO", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Contacto contacto;

	// endregion OneToOne

	// region OneToMany

	/*@OneToMany(fetch = FetchType.LAZY,
            mappedBy = "entidade")
	@JsonIgnore
    private Set<Provincia> mensagem = new HashSet<>();*/

	// endregion OneToMany

	// region ManyToMany



	//FUE_ENTIDADE$SOCIOS
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.ALL
			})
	@JoinTable(name = "FUE_ENTIDADE$SOCIOS",
			joinColumns = { @JoinColumn(name = "ID_ENTIDADE") },
			inverseJoinColumns = { @JoinColumn(name = "ID_SOCIO") })
	//@JsonIgnore
	private Set<Socio> socio = new HashSet<>();

	//FUE_ENTIDADE$ESTABELECIMENTOS
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.ALL
			})
	@JoinTable(name = "FUE_ENTIDADE$ESTABELECIMENTOS",
			joinColumns = { @JoinColumn(name = "ID_ENTIDADE") },
			inverseJoinColumns = { @JoinColumn(name = "ID_ESTABELE") })
	//@JsonIgnore
	private Set<Estabelecimento> estabelecimento = new HashSet<>();

	//FUE_ENTIDADE$EMPSPARTICIP
	/*@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "FUE_ENTIDADE$EMPSPARTICIP",
			joinColumns = { @JoinColumn(name = "ID_ENTIDADE") },
			inverseJoinColumns = { @JoinColumn(name = "ID_EMPAR") })
	//@JsonIgnore
	private Set<EmpresaParticipada> empresa_participada = new HashSet<>();*/

	//FUE_ENTIDADE$CAE_SEC
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "FUE_ENTIDADE$CAE_SEC",
			joinColumns = { @JoinColumn(name = "ID_ENTIDADE") },
			inverseJoinColumns = { @JoinColumn(name = "ID_CAE") })
	//@JsonIgnore
	private Set<CAE> cae = new HashSet<>();

	/*@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "entidade")
	@JsonIgnore
    private Set<Estabelecimento> estabelecimento = new HashSet<>();
*/
	// endregion ManyToMany


	@Column(name = "SEXO")
	private long sexo;

	@Field
	@Column(name = "IDADE")
	private float idade;

	@Field
	@Column(name = "VOLUME_VENDAS")
	private float volume_vendas;

	@Field
	@Column(name = "TIPO")
	private long tipo;

	@Field
	@Column(name = "PROFISSAO")
	@Size(min = 1, max = 500)
	private String profissao;

	@Field
	@Column(name = "INSTITUICAO")
	@Size(min = 1, max = 1)
	private String instituicao;

	@Field
	@Column(name = "PESSOA")
	@Size(min = 1, max = 400)
	private String pessoa;

	@Field
	@Column(name = "NUM_FUNCIONARIO")
	private float num_funcionario;

	@Field
	@Column(name = "NUM_FUNCIONARIO_HOMEM")
	private float num_funcionario_homem;


	@Field
	@Column(name = "NUM_FUNCIONARIO_MULHER")
	private float num_funcionario_mulher;



	@Column(name = "ESTADO")
	private float estado = 1;
	
	

	@Column(name = "ESTADO_APROVACAO")
	private float estado_aprovacao;


	@Field
	@Column(name = "DATA_CONSTITUICAO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_costituicao;
	
	

	@Column(name = "SITUACAO_EMPRESA")
	private long situacao_empresa;
	
	

	@Column(name = "FORMA_JURIDICA")
	private long forma_juridica;
		

	@Column(name = "CAPITAL_SOCIAL")
	private float capital_social;
	
	

	@Column(name = "CONTABILIDADE")
	private long contabilidade;
	
	

	@Column(name = "CAP_PUBLICO")
	private float cap_publico;
	
	

	@Column(name = "CAP_PRIVADO")
	private float cap_privado;
	
	

	@Column(name = "CAP_ESTRANG")
	private float cap_estrang;
	
	

	@Column(name = "ACTI_COMERCIAL")
	private long acti_comercial;


	@Field
	@Column(name = "DATA_DOCUMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_documento;


	@Column(name = "NUM_ESTABELECIMENTOS")
	private float num_estabelecimentos;
	

	@Column(name = "ACTI_ECO_PRINCIPAL")
	private long acti_eco_principal;
	
	

	@Column(name = "ORIGEM_DOC")
	private long origem_doc;
	
	

	@Column(name = "CANAL")
	private long canal;


	@Field
	@Column(name = "NIF")
	@Size(min = 1, max = 50)
	private String nif;


	@Column(name = "NUM_DOC")
	private float num_doc;


	@Field
	@Column(name = "ELIMINADO")
	@Size(min = 1, max = 1)
	private String eliminado;
	

	@Column(name = "ANO_ELIMINACAO")
	private long ano_eliminacao;
	
	
	@Column(name = "STATE")
	private float state;


	@Field
	@Column(name = "BI")
	@Size(max = 20)
	private String bi;

	@Field
	@Column(name = "NUM_RGE")
	@Size(max = 8)
	private String num_rge;
	
	
	@Column(name = "NUM_FUNC_REM")
	private float num_func_rem;
	
	
	
	@Column(name = "NUM_FUNC_HOMEM_REM")
	private float num_func_homem_rem;
	
	
	
	@Column(name = "NUM_FUNC_MULHER_REM")
	private float num_func_mulher_rem;
	

	@Column(name = "NUM_FUNC_NREM")
	private float num_func_nrem;
	
	@Column(name = "NUM_FUNC_HOMEM_NREM")
	private float num_func_homem_nrem;
	
	
	@Column(name = "NUM_FUNC_MULHER_NREM")
	private float num_func_mulher_nrem;

	@Field
	@Column(name = "DATA_SGE")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date data_sge;

	@Field
	@Column(name = "COMENTARIOENT")
	@Size(max = 400)
	private String comentarioent;

	@Field
	@Column(name = "DATASITUACAOACTIVIDADE")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date datasituacaoactividade;

	@Field
	@Column(name = "GRUPOHOLDING")
	@Size(max = 1)
	private String grupoholding;


	@Field
	@Column(name = "CODGRUPO")
	@Size(max = 4)
	private String codgrupo;

	@Field
	@Column(name = "DATACONSTGRUPO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataconstgrupo;


	@Field
	@Column(name = "DATAFIMGRUPO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date datafimgrupo;


	@Field
	@Column(name = "NOMEGRUPO")
	@Size(max = 160)
	private String nomegrupo;

	@Field
	@Column(name = "NIFGRUPO")
	@Size(max = 10)
	private String nifgrupo;


	@NotNull
	@Column(name = "SITUACAOACTIVGRUPO")
	private long situacaoactivgrupo;


	//@Field
	@Column(name = "DATAINITACTGRUPO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date datainitactgrupo;

	//@Field
	@Column(name = "DATAFIMACTGRUPO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date datafimactgrupo;
	
	
	
	@NotNull
	@Column(name = "NATUREZAJURGRUPO")
	private long naturezajurgrupo;
	
	
	@NotNull
	@Column(name = "CAEPRINCIPALGRUPO")
	private long caeprincipalgrupo;
	
	

	@Column(name = "NUMEMPRESASNACGRUPO")
	private float numempresasnacgrupo;
	

	@Column(name = "NUMEMPRESASESTGRUPO")
	private float numempresasestgrupo;
	

	@Column(name = "NUMPESSOASSERVGRUPO")
	private float numpessoasservgrupo;
	

	@Column(name = "VOLUMENEGOCIOGRUPO")
	private float volumenegociogrupo;

	@Field
	@Column(name = "NOMERESPGRUPO")
	@Size(max = 160)
	private String nomerespgrupo;


	@Field
	@Column(name = "TELEFONEINDGRUPO")
	@Size(max = 3)
	private String telefoneindgrupo;

	@Field
	@Column(name = "TELEFONEGRUPO")
	@Size(max = 12)
	private String telefonegrupo;


	@Field
	@Column(name = "FAXGRUPO")
	@Size(max = 12)
	private String faxgrupo;



	@Field
	@Column(name = "FAXINDGRUPO")
	@Size(max = 3)
	private String faxindgrupo;


	@Field
	@Column(name = "EMAILRESPGRUPO")
	@Size(max = 60)
	private String emailrespgrupo;


	@Field
	@Column(name = "WEBURLGRUPO")
	@Size(max = 100)
	private String weburlgrupo;


	@Column(name = "ORIGEMDOCGRUPO")
	private long origemdocgrupo;

	@Field
	@Column(name = "COMENTARIOGRUPO")
	@Size(max = 400)
	private String comentariogrupo;


	@Field
	@Column(name = "DATAULTIMAINSERCAO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataultimainsercao;
	

	@Column(name = "NUM_ESTABS_TOTAL")
	private float num_estabs_total;
	
	

	@Column(name = "NUM_FUNC_NAC")
	private float num_func_nac;
	

	@Column(name = "NUM_FUNC_EST")
	private float num_func_est;
	

	@Column(name = "NUM_FUNCIONARIO_H_NAC")
	private float num_funcionario_h_nac;
	

	@Column(name = "NUM_FUNCIONARIO_H_EST")
	private float num_funcionario_h_est;
	

	@Column(name = "NUM_FUNCIONARIO_M_NAC")
	private float num_funcionario_m_nac;
	

	@Column(name = "NUM_FUNCIONARIO_M_EST")
	private float num_funcionario_m_est;
	
	
	

	@Column(name = "NUM_FUNC_REM_NAC")
	private float num_func_rem_nac;
	

	@Column(name = "NUM_FUNC_REM_EST")
	private float num_func_rem_est;
	
	
	@Column(name = "NUM_FUNC_H_REM_NAC")
	private float num_func_h_rem_nac;
	

	@Column(name = "NUM_FUNC_H_REM_EST")
	private float num_func_h_rem_est;

	@Column(name = "NUM_FUNC_M_REM_NAC")
	private float num_func_m_rem_nac;

	@Column(name = "NUM_FUNC_M_REM_EST")
	private float num_func_m_rem_est;
	

	@Column(name = "NUM_FUNC_NREM_NAC")
	private float num_func_nrem_nac;
	
	
	@Column(name = "NUM_FUNC_NREM_EST")
	private float num_func_nrem_est;
	
	

	@Column(name = "NUM_FUNC_H_NREM_NAC")
	private float num_func_h_nrem_nac;
	
	
	@Column(name = "NUM_FUNC_H_NREM_EST")
	private float num_func_h_nrem_est;
	

	@Column(name = "NUM_FUNC_M_NREM_NAC")
	private float num_func_m_nrem_nac;


	@Column(name = "NUM_FUNC_M_NREM_EST")
	private float num_func_m_nrem_est;

	@Field
	@Column(name = "LATITUDE")
	@Size(max = 100)
	private String latitude;

	@Field
	@Column(name = "LONGITUDE")
	@Size(max = 100)
	private String longitude;

	@Column(name = "ANO_ACTIVIDADE")
	private float ano_actividade;
	

	@Column(name = "MESES_ACTIVIDADE")
	private float meses_actividade;

	@Field
	@Column(name = "GUE")
	@Size(max = 1)
	private String gue;

	@Field
	@Column(name = "SIAC")
	@Size(max = 1)
	private String siac;

	@Field
	@Column(name = "WEBURL")
	@Size(max = 100)
	private String weburl;


	@Column(name = "PAIS_ORIGEM")
	private long pais_origem;

	//region accessors for public property

	public String getNaturalId() {
		return naturalId;
	}

	public void setNaturalId(String naturalId) {
		this.naturalId = naturalId;
	}

	public float getSector() {
		return sector;
	}

	public void setSector(float sector) {
		this.sector = sector;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set <Socio> getSocio() {
		return socio;
	}

	public void setSocio(Set <Socio> socio) {
		this.socio = socio;
	}

	/*public Set <EmpresaParticipada> getEmpresa_participada() {
		return empresa_participada;
	}

	public void setEmpresa_participada(Set <EmpresaParticipada> empresa_participada) {
		this.empresa_participada = empresa_participada;
	}*/

	public Set <CAE> getCae() {
		return cae;
	}

	public void setCae(Set <CAE> cae) {
		this.cae = cae;
	}

	public Set <Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Set <Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAbreviatura() {
		return abreviatura;
	}


	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}


	/*public TituloAcademico getTitulo_academico() {
		return titulo_academico;
	}


	public void setTitulo_academico(TituloAcademico titulo_academico) {
		this.titulo_academico = titulo_academico;
	}
	*/

	public long getSexo() {
		return sexo;
	}


	public void setSexo(long sexo) {
		this.sexo = sexo;
	}


	public float getIdade() {
		return idade;
	}


	public void setIdade(float idade) {
		this.idade = idade;
	}


	public float getVolume_vendas() {
		return volume_vendas;
	}


	public void setVolume_vendas(float volume_vendas) {
		this.volume_vendas = volume_vendas;
	}


	/*public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}*/


	public long getTipo() {
		return tipo;
	}


	public void setTipo(long tipo) {
		this.tipo = tipo;
	}


	public String getProfissao() {
		return profissao;
	}


	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	public String getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}


	public String getPessoa() {
		return pessoa;
	}


	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}


	public float getNum_funcionario() {
		return num_funcionario;
	}


	public void setNum_funcionario(float num_funcionario) {
		this.num_funcionario = num_funcionario;
	}


	public float getNum_funcionario_homem() {
		return num_funcionario_homem;
	}


	public void setNum_funcionario_homem(float num_funcionario_homem) {
		this.num_funcionario_homem = num_funcionario_homem;
	}


	public float getNum_funcionario_mulher() {
		return num_funcionario_mulher;
	}


	public void setNum_funcionario_mulher(float num_funcionario_mulher) {
		this.num_funcionario_mulher = num_funcionario_mulher;
	}


	public Contacto getContacto() {
		return contacto;
	}


	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}


	public float getEstado() {
		return estado;
	}


	public void setEstado(float estado) {
		this.estado = estado;
	}


	public float getEstado_aprovacao() {
		return estado_aprovacao;
	}


	public void setEstado_aprovacao(float estado_aprovacao) {
		this.estado_aprovacao = estado_aprovacao;
	}


	public java.util.Date getData_costituicao() {
		return data_costituicao;
	}


	public void setData_costituicao(java.util.Date data_costituicao) {
		this.data_costituicao = data_costituicao;
	}


	public long getSituacao_empresa() {
		return situacao_empresa;
	}


	public void setSituacao_empresa(long situacao_empresa) {
		this.situacao_empresa = situacao_empresa;
	}


	public long getForma_juridica() {
		return forma_juridica;
	}


	public void setForma_juridica(long forma_juridica) {
		this.forma_juridica = forma_juridica;
	}


	public float getCapital_social() {
		return capital_social;
	}


	public void setCapital_social(float capital_social) {
		this.capital_social = capital_social;
	}


	public long getContabilidade() {
		return contabilidade;
	}


	public void setContabilidade(long contabilidade) {
		this.contabilidade = contabilidade;
	}


	public float getCap_publico() {
		return cap_publico;
	}


	public void setCap_publico(float cap_publico) {
		this.cap_publico = cap_publico;
	}


	public float getCap_privado() {
		return cap_privado;
	}


	public void setCap_privado(float cap_privado) {
		this.cap_privado = cap_privado;
	}


	public float getCap_estrang() {
		return cap_estrang;
	}


	public void setCap_estrang(float cap_estrang) {
		this.cap_estrang = cap_estrang;
	}


	public long getActi_comercial() {
		return acti_comercial;
	}


	public void setActi_comercial(long acti_comercial) {
		this.acti_comercial = acti_comercial;
	}


	public java.util.Date getData_documento() {
		return data_documento;
	}


	public void setData_documento(java.util.Date data_documento) {
		this.data_documento = data_documento;
	}


	public float getNum_estabelecimentos() {
		return num_estabelecimentos;
	}


	public void setNum_estabelecimentos(float num_estabelecimentos) {
		this.num_estabelecimentos = num_estabelecimentos;
	}


	public long getActi_eco_principal() {
		return acti_eco_principal;
	}


	public void setActi_eco_principal(long acti_eco_principal) {
		this.acti_eco_principal = acti_eco_principal;
	}


	public long getOrigem_doc() {
		return origem_doc;
	}


	public void setOrigem_doc(long origem_doc) {
		this.origem_doc = origem_doc;
	}


	public long getCanal() {
		return canal;
	}


	public void setCanal(long canal) {
		this.canal = canal;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public float getNum_doc() {
		return num_doc;
	}


	public void setNum_doc(float num_doc) {
		this.num_doc = num_doc;
	}


	public String getEliminado() {
		return eliminado;
	}


	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}


	public long getAno_eliminacao() {
		return ano_eliminacao;
	}


	public void setAno_eliminacao(long ano_eliminacao) {
		this.ano_eliminacao = ano_eliminacao;
	}


	


	public float getState() {
		return state;
	}


	public void setState(float state) {
		this.state = state;
	}


	public String getBi() {
		return bi;
	}


	public void setBi(String bi) {
		this.bi = bi;
	}


	public String getNum_rge() {
		return num_rge;
	}


	public void setNum_rge(String num_rge) {
		this.num_rge = num_rge;
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


	public java.util.Date getData_sge() {
		return data_sge;
	}


	public void setData_sge(java.util.Date data_sge) {
		this.data_sge = data_sge;
	}


	public String getComentarioent() {
		return comentarioent;
	}


	public void setComentarioent(String comentarioent) {
		this.comentarioent = comentarioent;
	}


	public java.util.Date getDatasituacaoactividade() {
		return datasituacaoactividade;
	}


	public void setDatasituacaoactividade(java.util.Date datasituacaoactividade) {
		this.datasituacaoactividade = datasituacaoactividade;
	}


	public String getGrupoholding() {
		return grupoholding;
	}


	public void setGrupoholding(String grupoholding) {
		this.grupoholding = grupoholding;
	}


	public String getCodgrupo() {
		return codgrupo;
	}


	public void setCodgrupo(String codgrupo) {
		this.codgrupo = codgrupo;
	}


	public java.util.Date getDataconstgrupo() {
		return dataconstgrupo;
	}


	public void setDataconstgrupo(java.util.Date dataconstgrupo) {
		this.dataconstgrupo = dataconstgrupo;
	}


	public java.util.Date getDatafimgrupo() {
		return datafimgrupo;
	}


	public void setDatafimgrupo(java.util.Date datafimgrupo) {
		this.datafimgrupo = datafimgrupo;
	}


	public String getNomegrupo() {
		return nomegrupo;
	}


	public void setNomegrupo(String nomegrupo) {
		this.nomegrupo = nomegrupo;
	}


	public String getNifgrupo() {
		return nifgrupo;
	}


	public void setNifgrupo(String nifgrupo) {
		this.nifgrupo = nifgrupo;
	}


	public long getSituacaoactivgrupo() {
		return situacaoactivgrupo;
	}


	public void setSituacaoactivgrupo(long situacaoactivgrupo) {
		this.situacaoactivgrupo = situacaoactivgrupo;
	}


	public java.util.Date getDatainitactgrupo() {
		return datainitactgrupo;
	}


	public void setDatainitactgrupo(java.util.Date datainitactgrupo) {
		this.datainitactgrupo = datainitactgrupo;
	}


	public java.util.Date getDatafimactgrupo() {
		return datafimactgrupo;
	}


	public void setDatafimactgrupo(java.util.Date datafimactgrupo) {
		this.datafimactgrupo = datafimactgrupo;
	}


	public long getNaturezajurgrupo() {
		return naturezajurgrupo;
	}


	public void setNaturezajurgrupo(long naturezajurgrupo) {
		this.naturezajurgrupo = naturezajurgrupo;
	}


	public long getCaeprincipalgrupo() {
		return caeprincipalgrupo;
	}


	public void setCaeprincipalgrupo(long caeprincipalgrupo) {
		this.caeprincipalgrupo = caeprincipalgrupo;
	}


	public float getNumempresasnacgrupo() {
		return numempresasnacgrupo;
	}


	public void setNumempresasnacgrupo(float numempresasnacgrupo) {
		this.numempresasnacgrupo = numempresasnacgrupo;
	}


	public float getNumempresasestgrupo() {
		return numempresasestgrupo;
	}


	public void setNumempresasestgrupo(float numempresasestgrupo) {
		this.numempresasestgrupo = numempresasestgrupo;
	}


	public float getNumpessoasservgrupo() {
		return numpessoasservgrupo;
	}


	public void setNumpessoasservgrupo(float numpessoasservgrupo) {
		this.numpessoasservgrupo = numpessoasservgrupo;
	}


	public float getVolumenegociogrupo() {
		return volumenegociogrupo;
	}


	public void setVolumenegociogrupo(float volumenegociogrupo) {
		this.volumenegociogrupo = volumenegociogrupo;
	}


	public String getNomerespgrupo() {
		return nomerespgrupo;
	}


	public void setNomerespgrupo(String nomerespgrupo) {
		this.nomerespgrupo = nomerespgrupo;
	}


	public String getTelefoneindgrupo() {
		return telefoneindgrupo;
	}


	public void setTelefoneindgrupo(String telefoneindgrupo) {
		this.telefoneindgrupo = telefoneindgrupo;
	}


	public String getTelefonegrupo() {
		return telefonegrupo;
	}


	public void setTelefonegrupo(String telefonegrupo) {
		this.telefonegrupo = telefonegrupo;
	}


	public String getFaxgrupo() {
		return faxgrupo;
	}


	public void setFaxgrupo(String faxgrupo) {
		this.faxgrupo = faxgrupo;
	}


	public String getFaxindgrupo() {
		return faxindgrupo;
	}


	public void setFaxindgrupo(String faxindgrupo) {
		this.faxindgrupo = faxindgrupo;
	}


	public String getEmailrespgrupo() {
		return emailrespgrupo;
	}


	public void setEmailrespgrupo(String emailrespgrupo) {
		this.emailrespgrupo = emailrespgrupo;
	}


	public String getWeburlgrupo() {
		return weburlgrupo;
	}


	public void setWeburlgrupo(String weburlgrupo) {
		this.weburlgrupo = weburlgrupo;
	}


	public long getOrigemdocgrupo() {
		return origemdocgrupo;
	}


	public void setOrigemdocgrupo(long origemdocgrupo) {
		this.origemdocgrupo = origemdocgrupo;
	}


	public String getComentariogrupo() {
		return comentariogrupo;
	}


	public void setComentariogrupo(String comentariogrupo) {
		this.comentariogrupo = comentariogrupo;
	}


	public java.util.Date getDataultimainsercao() {
		return dataultimainsercao;
	}


	public void setDataultimainsercao(java.util.Date dataultimainsercao) {
		this.dataultimainsercao = dataultimainsercao;
	}


	public float getNum_estabs_total() {
		return num_estabs_total;
	}


	public void setNum_estabs_total(float num_estabs_total) {
		this.num_estabs_total = num_estabs_total;
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


	public float getAno_actividade() {
		return ano_actividade;
	}


	public void setAno_actividade(float ano_actividade) {
		this.ano_actividade = ano_actividade;
	}


	public float getMeses_actividade() {
		return meses_actividade;
	}


	public void setMeses_actividade(float meses_actividade) {
		this.meses_actividade = meses_actividade;
	}


	public String getGue() {
		return gue;
	}


	public void setGue(String gue) {
		this.gue = gue;
	}


	public String getSiac() {
		return siac;
	}


	public void setSiac(String siac) {
		this.siac = siac;
	}


	public String getWeburl() {
		return weburl;
	}


	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}


	public long getPais_origem() {
		return pais_origem;
	}


	public void setPais_origem(long pais_origem) {
		this.pais_origem = pais_origem;
	}
	//endregion
}
