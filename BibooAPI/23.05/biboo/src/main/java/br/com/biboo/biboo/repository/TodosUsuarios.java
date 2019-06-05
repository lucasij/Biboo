package br.com.biboo.biboo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.biboo.biboo.domain.Usuario;


@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, String>{
	
	@Query(value="from Usuario where nome like ?1 and senha like ?2")
	public Usuario UsuarioComEssasCredenciais(String nome, String senha);
	
	
}