package br.com.biboo.biboo.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Login {

	private String nome;
	private String senha;
	
	public Login(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	
	
	
}
