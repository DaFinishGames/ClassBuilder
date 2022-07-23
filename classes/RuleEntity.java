package com.play.performance.Play.Performance.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "regola_entita")
public class RuleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idRegola;
	private long idEntita;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdRegola() {
		return idRegola;
	}
	public void setIdRegola(long idRegola) {
		this.idRegola = idRegola;
	}
	public long getIdEntita() {
		return idEntita;
	}
	public void setIdEntita(long idEntita) {
		this.idEntita = idEntita;
	}

}
