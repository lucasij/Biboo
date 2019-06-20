package br.com.biboo.biboo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biboo.biboo.domain.Pet;
import br.com.biboo.biboo.domain.Usuario;
import br.com.biboo.biboo.infra.Seguranca;
import br.com.biboo.biboo.repository.TodoPets;
import br.com.biboo.biboo.repository.TodosUsuarios;

@Controller
public class LoginController {

	private final Seguranca seguranca;
	private final TodosUsuarios todosUsuarios;
	private final TodoPets todosPets;
	private Usuario usuarioLogado;
	private ModelAndView model;
	
	public LoginController(Seguranca seguranca, TodosUsuarios todosUsuarios, TodoPets todosPets) {
		super();
		this.seguranca = seguranca;
		this.todosUsuarios = todosUsuarios;
		this.todosPets = todosPets;
		this.usuarioLogado = null;
		this.model = new ModelAndView();
	}
	
	@PostMapping("/login")
	public ModelAndView efetuarLogin(@ModelAttribute Credenciais credenciais) {
		this.usuarioLogado = seguranca.permitirAcesso(credenciais);
		if(usuarioLogado != null) {
			return exibirPáginaPrincinpal();
		}
		else {
			model.setViewName("erro");
			return model;
		}
	}
	
	@GetMapping("/login")
	public ModelAndView exibirPaginaDeLogin() {
		model.clear();
		this.usuarioLogado = null;
		model.addObject(new Credenciais(null, null));
		model.addObject(new Usuario(null, null, null, null, null, null));
		model.setViewName("index");
		return model;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView efetuarcadastro(@ModelAttribute Usuario usuario) {
		todosUsuarios.save(usuario);
		usuarioLogado = usuario;
		return exibirPáginaPrincinpal();
	}
	
	@GetMapping("/cadastro")
	public ModelAndView exibirPaginaDeCadastro() {
		model.clear();
		model.setViewName("cadastro");
		return model;
	}
	
	@PostMapping("/pets")
	public ModelAndView cadastrarDog(@ModelAttribute CredenciaisPet pet) {
		
		Pet petCadastrado = new Pet(pet); 
		petCadastrado.setCPF(usuarioLogado.getCPF());
		todosPets.salvarPet(petCadastrado.getCPF(), pet.getApelido(), pet.getIdade(), pet.getCor(), pet.getRaca(), pet.getPelagem(), pet.getTamanho());
		return exibirPáginaPrincinpal();
	}
	
	@GetMapping("/pets")
	public ModelAndView exibirPaginaDePets() {
		model.clear();
		if(usuarioLogado != null) {
			model.addObject( new CredenciaisPet( null , 0, null, null, null, 0.0));
			model.setViewName("dogs");
			return model;
		} else return exibirPaginaDeLogin() ;
	}
	
	@GetMapping("/principal")
	public ModelAndView exibirPáginaPrincinpal() {
		model.clear();
		if(usuarioLogado == null) return exibirPaginaDeLogin();
		ModelAndView model = new ModelAndView();
		List<Pet> pets =  todosPets.petsComApelido("%o%");
		
		List<CredenciaisPet> p = new ArrayList<CredenciaisPet>();
		for (Pet pet : pets) {
			p.add(pet.getPet());
			
		}
		model.addObject("pets",p);
		model.addObject("pesquisa", new Pesquisa(null));
		model.addObject("usuario",usuarioLogado);
		model.setViewName("blog-home");
		return model;
	}
	
	@PostMapping("/principal")
	public ModelAndView buscarPet(@ModelAttribute Pesquisa pesquisa) {
		model.clear();
		if(usuarioLogado == null) return exibirPaginaDeLogin();
		ModelAndView model = new ModelAndView();
		List<Pet> pets =  todosPets.petsComApelido("%"+pesquisa.getBusca()+"%");
		List<CredenciaisPet> p = new ArrayList<CredenciaisPet>();
		for (Pet pet : pets) {
			p.add(pet.getPet());
			
		}
		model.addObject("pets",p);
		model.addObject("pesquisa", new Pesquisa(null));
		model.setViewName("blog-home");
		return model;
	}
	
	@GetMapping("/perfil")
	public ModelAndView exibirPaginaDePerfil() {
		model.clear();
		if(usuarioLogado != null) {
			model.addObject("usuario",usuarioLogado);
			model.setViewName("atualiza_perfil");
			return model;
		} else return exibirPaginaDeLogin() ;
	}
	
	@GetMapping("/perfildog")
	public ModelAndView exibirPaginaDePerfildog() {
		model.clear();
		if(usuarioLogado != null) {
			model.addObject(usuarioLogado);
			model.setViewName("perfil_cachorro");
			return model;
		} else return exibirPaginaDeLogin() ;
	}
	
	@GetMapping("/home")
	public ModelAndView exibirPaginaHome() {
		model.clear();
		model.setViewName("home_page");
		return model;
		
	}
}
