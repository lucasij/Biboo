package br.com.biboo.biboo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.biboo.biboo.domain.Pet;

public interface TodoPets extends JpaRepository<Pet, Integer> {

	@Query(value="select from Tb_pet where apelido = ?1", nativeQuery= true)
	public Pet[] petsComApelido(String apelido);
	
	@Query(value="select from Tb_pet where CPF = ?1", nativeQuery= true)
	public Pet[] petsDeUsuarioApelido(String cpf);
	
	@Modifying
	@Transactional
	@Query(value="insert into Tb_pet (CPF,apelido,idade,cor,raca,pelagem,tamanho) values (?1, ?2, ?3, ?4, ?5, ?6, ?7) ",nativeQuery = true)
	public void salvarPet(String CPF, String apelido, Integer idade, String cor, String raca, String pelagem, Double tamanho);
}
