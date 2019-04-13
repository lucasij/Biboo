package br.com.biboo.biboo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.biboo.biboo.infra.SalvarUsuario;
import br.com.biboo.biboo.infra.Seguranca;

@Controller
public class LoginController {

	private final Seguranca seguranca;
	

	public LoginController(Seguranca seguranca) {
		super();
		this.seguranca = seguranca;
	}

	@PostMapping("/login")
	public String efetuarLogin(@ModelAttribute Credenciais credenciais) {
		if(seguranca.permitirAcesso(credenciais)) return "principal";
		else return "erro";
	}
	
	@GetMapping("/login")
	public String exibirPaginaDeLogin(Model model) {
		model.addAttribute(new Credenciais(null, null));
		return "index";
	}
	
	@PostMapping("/cadastro")
	public String efetuarcadastro(@ModelAttribute Credenciais credenciais) {
		SalvarUsuario usuario = new SalvarUsuario();
		usuario.salvarBanco(credenciais);
		return "principal";
	}
	
	@GetMapping("/cadastro")
	public String exibirPaginaDeCadastro(Model model) {
		model.addAttribute(new Credenciais(null, null));
		return "cadastro";
	}
}
