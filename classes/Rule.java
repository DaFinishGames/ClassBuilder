package com.play.performance.Play.Performance.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "regola")
public class Rule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRegola;
	private long idDominio;
	private String nome;
	private String descrizione;
	private String implementazione;
	
	public long getIdRegola() {
		return idRegola;
	}
	public void setIdRegola(long idRegola) {
		this.idRegola = idRegola;
	}
	public long getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(long idDominio) {
		this.idDominio = idDominio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getImplementazione() {
		return implementazione;
	}
	public void setImplementazione(String implementazione) {
		this.implementazione = implementazione;
	}
}
