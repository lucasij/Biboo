package br.com.biboo.biboo.infra;

import br.com.biboo.biboo.controler.Credenciais;

public class Seguranca {
	
	public static Boolean permitirAcesso(Credenciais credenciais) {
		
		if(credenciais.getUsuario().equals("lucas") && credenciais.getSenha().equals("keven") ) {
			return true;
		}
		
		return false;
		
	}
	
	
}
