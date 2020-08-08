package cl.awakelab.springaprl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awakelab.springaprl.dao.EmpresaDao;
import cl.awakelab.springaprl.model.Empresa;

@Controller
public class EmpresaController {

	@Autowired
	EmpresaDao ed;
	
	@RequestMapping(value="/VerEmpresas", method=RequestMethod.GET)
	public ModelAndView listadoEmpresas() {
		
		List<Empresa> listado = ed.listarEmpresas();
		
		return new ModelAndView ("VerEmpresas", "listaempresas", listado);
	}
	
	@RequestMapping(value="/EditarEmpresa/{id}", method=RequestMethod.GET)
	public ModelAndView editarEmpresas(@PathVariable String id) {
		
		Empresa e = ed.getById(id);
		return new ModelAndView("EditarEmpresa", "datos", e);
	}
	
	@RequestMapping(value="/EditarEmpresa", method=RequestMethod.POST)
	public ModelAndView actualizarEmpresa(@RequestParam("rute") String rutEmpresa, @RequestParam("empresa") String nombreEmpresa, @RequestParam("direccion") String direccion, @RequestParam("contacto") String contacto, 
			@RequestParam("telefono") String telefono, @RequestParam("correo") String mailContacto, @RequestParam("cantidad") int headCount, RedirectAttributes mensajes ) {
		
		Empresa e = new Empresa(rutEmpresa, nombreEmpresa, direccion, contacto, telefono, mailContacto, headCount);
		
		String mensaje = "";
		
		int editar = ed.editar(e);
		
		if(editar > 0) {
			mensaje = "Datos de Empresa Actualizados";
			
		}else {
			mensaje = "Error al actualizar datos de Empresa";
		}
		
		mensajes.addFlashAttribute("mensaje", mensaje);
		return new ModelAndView("redirect:/VerEmpresas");
		
	}
	
	@RequestMapping(value="/CrearEmpresa", method=RequestMethod.GET)
	public String crearEmpresa(Locale locale, Model model) {
		return "CrearEmpresa";
	}
	
	@RequestMapping(value="/CrearEmpresa", method=RequestMethod.POST)
	public ModelAndView crearEmpresa(@RequestParam("rute") String rutEmpresa, @RequestParam("empresa") String nombreEmpresa, @RequestParam("direccion") String direccion, @RequestParam("contacto") String contacto, 
			@RequestParam("telefono") String telefono, @RequestParam("correo") String mailContacto, @RequestParam("cantidad") int headCount) {
		
		Empresa e = new Empresa(rutEmpresa, nombreEmpresa, direccion, contacto, telefono, mailContacto, headCount);
		
		int agregar = ed.crear(e);
		
		String mensaje ="";
		
		if(agregar > 0)
			mensaje= "Empresa Creada Exitosamente";
		else
			mensaje = "Error al crear Empresa";
		
		return new ModelAndView("CrearEmpresa", "mensaje", mensaje);
		
	}
	
	@RequestMapping(value="/BorrarEmpresa/{id}", method=RequestMethod.GET)
	public ModelAndView eliminarEmpresa(@PathVariable String id, RedirectAttributes mensajes) {
		
		Empresa e = new Empresa();
		e.setRutEmpresa(id);
		int elimino = ed.eliminar(e);
		String mensaje ="";
		if(elimino > 0)
			mensaje = "Empresa eliminada";
		else
			mensaje = "Ocurrió un error al intentar eliminar la empresa";
		
		mensajes.addFlashAttribute("mensaje", mensaje);
		
		return new ModelAndView("redirect:/VerEmpresas");
	}
	
	@RequestMapping(value="/Accidentabilidad", method=RequestMethod.GET)
	public ModelAndView listaAccidentabilidad() {
		
		List<Empresa> listado = ed.listaAccidentabilidad();
		
		return new ModelAndView ("Accidentabilidad", "listaempresas", listado);
	}
}
