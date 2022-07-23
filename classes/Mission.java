package com.play.performance.Play.Performance.DataObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "missione")
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMissione;
	private long idDominio;
	private String nome;
	private String descrizione;
	private int valorePunteggio;
	private Date inizioValidita;
	private Date fineValidita;
	
	public long getIdMissione() {
		return idMissione;
	}
	public void setIdMissione(long idMissione) {
		this.idMissione = idMissione;
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
	public int getValorePunteggio() {
		return valorePunteggio;
	}
	public void setValorePunteggio(int valorePunteggio) {
		this.valorePunteggio = valorePunteggio;
	}
	public Date getInizioValidita() {
		return inizioValidita;
	}
	public void setInizioValidita(Date inizioValidita) {
		this.inizioValidita = inizioValidita;
	}
	public Date getFineValidita() {
		return fineValidita;
	}
	public void setFineValidita(Date fineValidita) {
		this.fineValidita = fineValidita;
	}
}
