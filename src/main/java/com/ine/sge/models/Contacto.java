package com.ine.sge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Indexed
@Entity
@Table(name="FUE_CONTACTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contacto extends AuditModel<String> implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CONTACTO")
	//@JsonIgnore
	private long id;

	@Field
	@Column(name = "EMAIL")
	@Email
	@Size(max=60)
	private String email;

	@Field
	@Column(name = "MORADA")
	@Size(max=120)
	private String morada;

	@Field
	@Column(name = "COD_POSTAL")
	@Size(max=15)
	private String cod_postal;


	@Column(name = "COMUNA")
	private float comuna;

	@Column(name = "MUNICIPIO")
	private float municipio;

	@Column(name = "PROVINCIA")
	private float provincia;

	@Column(name = "PAIS")
	private float pais;


	@Field
	@Column(name = "TELEFONE_IND")
	@Size(max=3)
	private String telefone_ind;

	@Field
	@Column(name = "TELEFONE")
	@Size(max=40)
	private String telefone;

	@Field
	@Column(name = "TELEMOVEL_IND")
	@Size(max=3)
	private String telemovel_ind;

	@Field
	@Column(name = "TELEMOVEL")
	@Size(max=40)
	private String telemovel;

	@Field
	@Column(name = "FAX")
	@Size(max=40)
	private String fax;

	@Field
	@Column(name = "FAX_IND")
	@Size(max=3)
	private String fax_ind;

	@Field
	@Column(name = "PORTA")
	@Size(max=15)
	private String porta;

	@Field
	@Column(name = "CASA")
	@Size(max=4)
	private String casa;

	@Field
	@Column(name = "PISO")
	@Size(max=2)
	private String piso;

	@Field
	@Column(name = "PORTAPISO")
	@Size(max=3)
	private String portapiso;

	@Field
	@Column(name = "WEBURL")
	@Size(max=100)
	private String weburl;
	
	@Column(name = "ESTADO")
	private float estado = 1;


	//region accessors for private property

	public float getComuna() {
		return comuna;
	}

	public void setComuna(float comuna) {
		this.comuna = comuna;
	}

	public float getMunicipio() {
		return municipio;
	}

	public void setMunicipio(float municipio) {
		this.municipio = municipio;
	}

	public float getProvincia() {
		return provincia;
	}

	public void setProvincia(float provincia) {
		this.provincia = provincia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	public float getPais() {
		return pais;
	}

	public void setPais(float pais) {
		this.pais = pais;
	}

	public String getTelefone_ind() {
		return telefone_ind;
	}

	public void setTelefone_ind(String telefone_ind) {
		this.telefone_ind = telefone_ind;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelemovel_ind() {
		return telemovel_ind;
	}

	public void setTelemovel_ind(String telemovel_ind) {
		this.telemovel_ind = telemovel_ind;
	}

	public String getTelemovel() {
		return telemovel;
	}

	public void setTelemovel(String telemovel) {
		this.telemovel = telemovel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax_ind() {
		return fax_ind;
	}

	public void setFax_ind(String fax_ind) {
		this.fax_ind = fax_ind;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPortapiso() {
		return portapiso;
	}

	public void setPortapiso(String portapiso) {
		this.portapiso = portapiso;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public float getEstado() {
		return estado;
	}

	public void setEstado(float estado) {
		this.estado = estado;
	}
	//endregion
}
