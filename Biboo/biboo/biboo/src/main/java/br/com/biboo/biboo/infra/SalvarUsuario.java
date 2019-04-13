package br.com.biboo.biboo.infra;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biboo.biboo.controler.Credenciais;
import br.com.biboo.biboo.domain.Usuario;
import br.com.biboo.biboo.repository.TodosUsuarios;

public class SalvarUsuario {
	
	private final TodosUsuarios todosusuarios;
	
	@Autowired
	public SalvarUsuario(TodosUsuarios todosUsuarios) {
		super();
		this.todosusuarios = todosUsuarios;
	}

	public void salvarBanco(Credenciais credenciais)	{
		Usuario novoUsuario = new Usuario(credenciais.getUsuario(), credenciais.getSenha());
		todosusuarios.save(novoUsuario);
	}
	
	
	
}
