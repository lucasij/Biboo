package br.com.biboo.biboo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tb_Match")
public class Match {
	
	@Id
	private int id_match;
	private int deuLike;
	private int recebeueLike;
	
	public Match(int id_match, int deuLike, int recebeueLike) {
		super();
		this.id_match = id_match;
		this.deuLike = deuLike;
		this.recebeueLike = recebeueLike;
	}
	
	public Match() {
		super();
	}

	public int getId_match() {
		return id_match;
	}

	public void setId_match(int id_match) {
		this.id_match = id_match;
	}

	public int getDeuLike() {
		return deuLike;
	}

	public void setDeuLike(int deuLike) {
		this.deuLike = deuLike;
	}

	public int getRecebeueLike() {
		return recebeueLike;
	}

	public void setRecebeueLike(int recebeueLike) {
		this.recebeueLike = recebeueLike;
	}
	
	
	
	
}
