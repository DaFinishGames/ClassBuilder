package com.play.performance.Play.Performance.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tipi_punti_dominio")
public class DomainPointsType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idDominio;
	private long idTipoPunti;
	private boolean principale;
	private int moltiplicatoreBase;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public boolean isPrincipale() {
		return principale;
	}
	public void setPrincipale(boolean principale) {
		this.principale = principale;
	}
	public int getMoltiplicatoreBase() {
		return moltiplicatoreBase;
	}
	public void setMoltiplicatoreBase(int moltiplicatoreBase) {
		this.moltiplicatoreBase = moltiplicatoreBase;
	}
}
