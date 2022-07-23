package com.play.performance.Play.Performance.DataObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "punti")
public class Points {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idUtente;
	private long idDominio;
	private long idTipoPunti;
	private int punti;
	private Date dataAssegnazione;
	private String classeOriginePunti;
	private long idOriginePunti;
	
	public Points(){
		setDataAssegnazione(new Date());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public long getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(long idDominio) {
		this.idDominio = idDominio;
	}
	public long getIdTipoPunti() {
		return idTipoPunti;
	}
	public void setIdTipoPunti(long idTipoPunti) {
		this.idTipoPunti = idTipoPunti;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public Date getDataAssegnazione() {
		return dataAssegnazione;
	}
	public void setDataAssegnazione(Date dataAssegnazione) {
		this.dataAssegnazione = dataAssegnazione;
	}
	public String getClasseOriginePunti() {
		return classeOriginePunti;
	}
	public void setClasseOriginePunti(String classeOriginePunti) {
		this.classeOriginePunti = classeOriginePunti;
	}
	public long getIdOriginePunti() {
		return idOriginePunti;
	}
	public void setIdOriginePunti(long idOriginePunti) {
		this.idOriginePunti = idOriginePunti;
	}
}
