package com.play.performance.Play.Performance.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tipo_punti")
public class PointsType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipoPunti;
	private String nomePunti;
	public long getIdTipoPunti() {
		return idTipoPunti;
	}
	public void setIdTipoPunti(long idTipoPunti) {
		this.idTipoPunti = idTipoPunti;
	}
	public String getNomePunti() {
		return nomePunti;
	}
	public void setNomePunti(String nomePunti) {
		this.nomePunti = nomePunti;
	}
}
