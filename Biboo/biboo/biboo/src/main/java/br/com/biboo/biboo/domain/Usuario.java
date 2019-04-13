package br.com.biboo.biboo.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private UUID ID;
	private String USUARIO;
	private String SENHA;
	
	
	public Usuario(String login, String senha) {
		super();
		this.USUARIO = login;
		this.SENHA = senha;
	}
	
	public UUID getId() {
		return ID;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public String getSENHA() {
		return SENHA;
	}
	
	
}
