package br.com.biboo.biboo.controler;

import javax.persistence.Embeddable;

@Embeddable
public class CredenciaisPet {

	
	private String apelido;
	private Integer idade;
	private String cor;
	private String raca;
	private String pelagem;
	private Double tamanho;
	
	public CredenciaisPet( String apelido, Integer idade, String cor, String raca, String pelagem, Double tamanho) {
		super();
		
		this.apelido = apelido;
		this.idade = idade;
		this.cor = cor;
		this.raca = raca;
		this.pelagem = pelagem;
		this.tamanho = tamanho;
	}
	
	public CredenciaisPet() {}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
}
