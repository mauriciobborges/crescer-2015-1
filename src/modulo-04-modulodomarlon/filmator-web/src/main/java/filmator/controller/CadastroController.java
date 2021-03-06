package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.TipoUsuario;
import filmator.model.Usuario;

@Controller
public class CadastroController {
			
		@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
		public String home(Model model, HttpSession session) {
			Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
			if(usuariologado!=null&&usuariologado.getTipo()==TipoUsuario.ADMIN){
				return "cadastro";
			}else{
				return "redirect:/error";
			}
		}
		
		@Inject
		private FilmeDao dao;
		
		@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
		public String inserir(Filme filme, Model model, HttpSession session) {
			Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
			if(usuariologado!=null&&usuariologado.getTipo()==TipoUsuario.ADMIN){
				dao.inserir(filme);
				return "redirect:/lista";
			}else{
				return "redirect:/error";
			}
		}
}
