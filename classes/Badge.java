package com.play.performance.Play.Performance.DataObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Badge")
public class Badge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBadge;
	private long idDominio;
	private String nome;
	private int valorePunteggio;
	private boolean cumulabile;
	private Date inizioValidita;
	private Date fineValidita;
	
	public long getIdBadge() {
		return idBadge;
	}
	public void setIdBadge(long idBadge) {
		this.idBadge = idBadge;
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
	public int getValorePunteggio() {
		return valorePunteggio;
	}
	public void setValorePunteggio(int valorePunteggio) {
		this.valorePunteggio = valorePunteggio;
	}
	public boolean isCumulabile() {
		return cumulabile;
	}
	public void setCumulabile(boolean cumulabile) {
		this.cumulabile = cumulabile;
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
