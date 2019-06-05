package br.com.biboo.biboo.controler;

public class Credenciais {
	
	private String CPF;
	private String nome;
	private String senha;
	private String email;
	private String telefone;
	
	public Credenciais(String cPF, String nome, String senha, String email, String telefone) {
		super();
		this.CPF = cPF;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Credenciais(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public Credenciais() {
		super();
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
