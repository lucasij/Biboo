package br.com.biboo.biboo.domain;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.biboo.biboo.controler.CredenciaisPet;

@Entity
@Table(name="Tb_Pet")
public class Pet {
	@Id
	private String ID_PET;
	private String CPF;
	@Embedded
	private CredenciaisPet pet;

	public Pet(CredenciaisPet pet) {
		super();
		this.pet = pet;
	}
	

	public Pet() {
		super();
	}


	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public CredenciaisPet getPet() {
		return pet;
	}


	public void setPet(CredenciaisPet pet) {
		this.pet = pet;
	}
	
	

}
