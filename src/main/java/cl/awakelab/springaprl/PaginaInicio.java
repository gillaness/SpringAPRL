package cl.awakelab.springaprl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awakelab.springaprl.dao.UsuarioDao;
import cl.awakelab.springaprl.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PaginaInicio {
	
	@Autowired
	UsuarioDao ud;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio() {

		
		return "Inicio";
	}
	
	@RequestMapping(value = "/Nosotros", method = RequestMethod.GET)
	public String nosotros() {

		
		return "Nosotros";
	}
	
	@RequestMapping(value = "/Servicios", method = RequestMethod.GET)
	public String servicios() {

		
		return "Servicios";
	}
	
	@RequestMapping(value="/VistaAdministrador", method=RequestMethod.GET)
	public String admin() {
		return "VistaAdministrador";
	}
	
	@RequestMapping(value="/VistaCliente", method=RequestMethod.GET)
	public String cliente(Model m) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = ud.getById(name);
		m.addAttribute("user", u);
		return "VistaCliente";
	}
	
	@RequestMapping(value="/VistaProfesional", method=RequestMethod.GET)
	public String profesional() {
		return "VistaProfesional";
	}
	  
	  @RequestMapping(value="/login") 
	  public ModelAndView login() { 
		  System.out.println("longi");
		  return new ModelAndView("logon");
	  
	  }
	  
	  @RequestMapping("/error") public String error(ModelMap model) {
	  model.addAttribute("error", "true"); return "logon";
	  
	  }
	  
	  
	  @RequestMapping("/logout")
	  public String logout() {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if(auth != null) {
			  SecurityContextHolder.getContext().setAuthentication(null);
		  }
		  
		  return "redirect:/";
	  }
	 
}
