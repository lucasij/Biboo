package br.com.biboo.biboo.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biboo.biboo.controler.Credenciais;
import br.com.biboo.biboo.controler.CredenciaisLogin;
import br.com.biboo.biboo.domain.Usuario;
import br.com.biboo.biboo.repository.TodosUsuarios;

@Component
public class Seguranca {
	
	private final TodosUsuarios todosusarios;
	
	@Autowired
	public Seguranca(TodosUsuarios todosUsuario) {
		this.todosusarios = todosUsuario;
	}
	
	public Usuario permitirAcesso(Credenciais credenciais) {
		Usuario usuarioEncontrado = todosusarios.UsuarioComEssasCredenciais(credenciais.getNome(), credenciais.getSenha());
		return usuarioEncontrado;
	}
	
	
}
