package com.play.performance.Play.Performance.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "dominio")
public class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDominio;
	private String nomeDominio;
	
	public long getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(long idDominio) {
		this.idDominio = idDominio;
	}
	public String getNomeDominio() {
		return nomeDominio;
	}
	public void setNomeDominio(String nomeDominio) {
		this.nomeDominio = nomeDominio;
	}
}
