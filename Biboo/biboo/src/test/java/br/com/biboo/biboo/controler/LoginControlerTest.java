package br.com.biboo.biboo.controler;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import br.com.biboo.biboo.domain.Usuario;
import br.com.biboo.biboo.infra.Seguranca;
import br.com.biboo.biboo.repository.TodosUsuarios;

import br.com.biboo.biboo.repository.TodoPets;


public class LoginControlerTest {
	
	
	
	@Test
	public void aoDigitarLoginESenhaValidosAbrirTelaPrincipal() {
		Usuario usurioDoBanco = new Usuario("121232", "lucas", "batata", null, "11976996088", "São Paulo");
		Seguranca seguranca = Mockito.mock(Seguranca.class);
		Credenciais credenciais = Mockito.mock(Credenciais.class);
		TodosUsuarios todosUsuarios = Mockito.mock(TodosUsuarios.class);
		TodoPets todosPets = Mockito.mock(TodoPets.class);
		Mockito.when(seguranca.permitirAcesso(credenciais)).thenReturn(usurioDoBanco);
		LoginController controller = new LoginController(seguranca, todosUsuarios, todosPets);
		
		assertEquals("principa",controller.efetuarLogin(credenciais).getViewName());
					
	}
}
























