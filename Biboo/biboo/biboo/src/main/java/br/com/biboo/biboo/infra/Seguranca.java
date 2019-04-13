package br.com.biboo.biboo.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biboo.biboo.controler.Credenciais;
import br.com.biboo.biboo.repository.TodosUsuarios;

@Component
public class Seguranca {
	
	private final TodosUsuarios todosusarios;
	
	@Autowired
	public Seguranca(TodosUsuarios todosUsuario) {
		this.todosusarios = todosUsuario;
	}
	
	public Boolean permitirAcesso(Credenciais credenciais) {
		System.out.println(todosusarios.contemUsuarioComEssas(credenciais));
		String[] logins = todosusarios.contemUsuarioComEssas(credenciais);
		for (String login : logins) {
			String[] campos = new String[2];
			campos = login.split(",");
			if(campos[0].equals(credenciais.getUsuario()) && campos[1].equals(credenciais.getSenha())) {
				return true;
			}
			
		}
		return false;
		
	}
	
	
}
