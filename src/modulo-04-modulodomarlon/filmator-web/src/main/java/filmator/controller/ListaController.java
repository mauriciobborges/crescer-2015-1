package filmator.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Usuario;

@Controller
public class ListaController {

	@Inject
	private FilmeDao dao;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
		if(usuariologado!=null){
			model.addAttribute("listaFilmes", dao.lista());
			return "lista";
		}else{
			return "redirect:/erro";
		}
	}
}