package com.play.performance.Play.Performance.DataObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "utente")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUtente;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date dataNascita;
	private String luogoNascita;
	private char sesso;
	private String indirizzoResidenza;
	private String provinciaResidenza;
	private int civicoResidenza;
	private String indirizzoDomicilio;
	private String provinciaDomicilio;
	private int civicoDomicilio;
	
	public User(){}
	public User(long id){
		setIdUtente(id);
	}
	
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	public String getProvinciaResidenza() {
		return provinciaResidenza;
	}
	public void setProvinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}
	public int getCivicoResidenza() {
		return civicoResidenza;
	}
	public void setCivicoResidenza(int civicoResidenza) {
		this.civicoResidenza = civicoResidenza;
	}
	public String getIndirizzoDomicilio() {
		return indirizzoDomicilio;
	}
	public void setIndirizzoDomicilio(String indirizzoDomicilio) {
		this.indirizzoDomicilio = indirizzoDomicilio;
	}
	public String getProvinciaDomicilio() {
		return provinciaDomicilio;
	}
	public void setProvinciaDomicilio(String provinciaDomicilio) {
		this.provinciaDomicilio = provinciaDomicilio;
	}
	public int getCivicoDomicilio() {
		return civicoDomicilio;
	}
	public void setCivicoDomicilio(int civicoDomicilio) {
		this.civicoDomicilio = civicoDomicilio;
	}

}
