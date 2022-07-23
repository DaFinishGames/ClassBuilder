package com.play.performance.Play.Performance.DataObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "leaderboard")
public class Leaderboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLeaderboard;
	private long idDominio;
	private long idTipoLeaderboard;
	private String opzionale;
	private String nome;
	private boolean visibile;
	private Date dataInizioConteggio;
	private Date dataFineConteggio;
	private int numeroReset;
	
	public long getIdLeaderboard() {
		return idLeaderboard;
	}
	public void setIdLeaderboard(long idLeaderboard) {
		this.idLeaderboard = idLeaderboard;
	}
	public long getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(long idDominio) {
		this.idDominio = idDominio;
	}
	public long getIdTipoLeaderboard() {
		return idTipoLeaderboard;
	}
	public void setIdTipoLeaderboard(long idTipoLeaderboard) {
		this.idTipoLeaderboard = idTipoLeaderboard;
	}
	public String getOpzionale() {
		return opzionale;
	}
	public void setOpzionale(String opzionale) {
		this.opzionale = opzionale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isVisibile() {
		return visibile;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	public Date getDataInizioConteggio() {
		return dataInizioConteggio;
	}
	public void setDataInizioConteggio(Date dataInizioConteggio) {
		this.dataInizioConteggio = dataInizioConteggio;
	}
	public Date getDataFineConteggio() {
		return dataFineConteggio;
	}
	public void setDataFineConteggio(Date dataFineConteggio) {
		this.dataFineConteggio = dataFineConteggio;
	}
	public int getNumeroReset() {
		return numeroReset;
	}
	public void setNumeroReset(int numeroReset) {
		this.numeroReset = numeroReset;
	}
}
