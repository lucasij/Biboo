package br.com.biboo.biboo.controler;

public class CredenciaisLogin {
	private String nome;
	private String senha;
	public CredenciaisLogin(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	public CredenciaisLogin() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
