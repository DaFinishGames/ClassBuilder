package com.play.performance.Play.Performance.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tipo_leaderboard")
public class LeaderboardType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipoLeaderboard;
	private String nomeTipo;
	
	public long getIdTipoLeaderboard() {
		return idTipoLeaderboard;
	}
	public void setIdTipoLeaderboard(long idTipoLeaderboard) {
		this.idTipoLeaderboard = idTipoLeaderboard;
	}
	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
}
