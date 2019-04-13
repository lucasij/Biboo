package br.com.biboo.biboo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.biboo.biboo.controler.Credenciais;
import br.com.biboo.biboo.domain.Usuario;


@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, UUID>{
	
	@Query(value="select USUARIO, SENHA from usuario", nativeQuery= true)
	public String[] contemUsuarioComEssas(Credenciais credenciais);
}