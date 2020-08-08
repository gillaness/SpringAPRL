package cl.awakelab.springaprl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.awakelab.springaprl.dao.AccidenteDao;
import cl.awakelab.springaprl.dao.UsuarioDao;
import cl.awakelab.springaprl.model.Accidente;
import cl.awakelab.springaprl.model.User;

@Controller
public class AccidenteController {

	@Autowired
	AccidenteDao ad;
	@Autowired
	UsuarioDao ud;

	@RequestMapping(value = "/ReportarAccidente", method = RequestMethod.GET)
	public String reportarAccidente(Model m) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = ud.getById(name);
		m.addAttribute("user", u);
		
		return "ReportarAccidente";
	}

	@RequestMapping(value = "/ReportarAccidente", method = RequestMethod.POST)
	public ModelAndView reportarAccidente(@RequestParam("idUser")String id, @RequestParam("idEmpresa") int empresa, @RequestParam("accidentado") String accidentado, 
			@RequestParam("fechaaccidente") String fechaaccidente, @RequestParam("horaaccidente") String horaaccidente, @RequestParam("area") String area, 
			@RequestParam("tipo") int tipo, @RequestParam("detalleaccidente") String detalleaccidente, Model m) {
		
		Accidente a = new Accidente(detalleaccidente, fechaaccidente, horaaccidente, area, tipo, id, empresa, accidentado);
		
		int agregar = ad.crear(a);
		
		String mensaje = "";
		
		if(agregar > 0)
			mensaje = "Accidente Registrado";
		else
			mensaje = "Error al registrar accidente";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = ud.getById(name);
		m.addAttribute("user", u);
		return new ModelAndView("ReportarAccidente", "mensaje", mensaje);
	}

	
}
