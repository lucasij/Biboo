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
}
