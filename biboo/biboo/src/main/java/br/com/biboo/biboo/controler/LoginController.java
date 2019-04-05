package br.com.biboo.biboo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.biboo.biboo.infra.Seguranca;

@Controller
public class LoginController {

	Seguranca seguranca = new Seguranca();
	
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
}
