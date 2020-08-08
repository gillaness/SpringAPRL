package cl.awakelab.springaprl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awakelab.springaprl.dao.EmpresaDao;
import cl.awakelab.springaprl.dao.UsuarioDao;
import cl.awakelab.springaprl.model.Empresa;
import cl.awakelab.springaprl.model.User;

@Controller
public class UserController {
	
	@Autowired
	UsuarioDao ud;
	@Autowired
	EmpresaDao ed;
	
	@RequestMapping(value="/VerUsuarios", method=RequestMethod.GET)
	public ModelAndView listadoUsuarios() {
		
		List<User> listado = ud.listarUsuarios();
		
		return new ModelAndView("VerUsuarios", "listausers", listado);
	}
	
	@RequestMapping(value="/EditarUsuario/{id}", method=RequestMethod.GET)
	public ModelAndView editarUsuarios(@PathVariable String id, Model model) {
		
		List<Empresa> lempresas = ed.listarEmpresas();
		User u = ud.getById(id);
		model.addAttribute("listaempresas", lempresas);
		return new ModelAndView("EditarUsuario", "datos", u);
	}
	
	@RequestMapping(value="/EditarUsuario", method=RequestMethod.POST)
	public ModelAndView editarUsuarios(@RequestParam("userId") String id, @RequestParam("nombre") String nombre, @RequestParam("empresa") int empresa, @RequestParam("perfil") int perfil, 
			RedirectAttributes mensajes){
		
		User u = new User(id, nombre, perfil, empresa);
		
		String mensaje = "";
		
		int editar = ud.editar(u);
		
		if (editar > 0)
			mensaje = "Usuario Actualizado";
		else
			mensaje = "Ocurrió un problema al actualizar el usuario";
		
		mensajes.addFlashAttribute("mensaje", mensaje);
		
		return new ModelAndView("redirect:/VerUsuarios");
	}
	
	@RequestMapping(value="/CrearUsuario", method=RequestMethod.GET)
	public ModelAndView crearUsuario() {
		
		List<Empresa> lempresas = ed.listarEmpresas();
		
		return new ModelAndView("CrearUsuario", "listaempresas", lempresas) ;
	}
	
	@RequestMapping(value="/CrearUsuario", method=RequestMethod.POST)
	public ModelAndView crearUsuario(@RequestParam("rut") String id, @RequestParam("nombre") String nombre, @RequestParam("pass") String password, @RequestParam("perfil") int perfil,
			@RequestParam("empresa") int empresa) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		
		User u = new User(id,nombre, encodedPassword, perfil, empresa); 
		
		int agregar = ud.crear(u);
		
		String mensaje = "";
		
		if(agregar > 0)
			mensaje = "Usuario agregado exitosamente";
		else
			mensaje = "Error al crear el usuario";
		
		return new ModelAndView("CrearUsuario", "mensaje", mensaje);
	}
	
	@RequestMapping(value="/BorrarUsuario/{id}", method=RequestMethod.GET)
	public ModelAndView eliminarUsuario(@PathVariable String id, RedirectAttributes mensajes) {
		User u = new User();
		u.setId(id);
		int elimino = ud.eliminar(u);
		String mensaje = "";
		if (elimino > 0)
			mensaje = "El usuario ha sido eliminado exitosamente";
		else
			mensaje = "Ocurrió un problema al eliminar el usuario";
		
		mensajes.addFlashAttribute("mensaje", mensaje);
		
		return new ModelAndView("redirect:/VerUsuarios");
	}
	
	@RequestMapping(value="/CambiarPassword/{id}", method=RequestMethod.GET)
	public ModelAndView encontrarPorId(@PathVariable String id) {
		
		User u = ud.getById(id);
		return new ModelAndView("/CambiarPassword", "datos", u);
	}
	
	@RequestMapping(value="/PasswordActualizado", method=RequestMethod.POST)
	public ModelAndView actualizarPassword(@RequestParam("userId") String id, @RequestParam("nombre") String nombre, @RequestParam("perfil") int perfil,
			@RequestParam("empresa") int empresa, @RequestParam("password") String password, @RequestParam("password1") String password1, Model model, RedirectAttributes mensajes) {
		
		User u = new User(id, nombre, password, perfil, empresa);
		
		String mensaje = "";
		
		if(password == ""||password1 ==""){
			mensaje = "No se aceptan campos nulos";
			System.out.println(mensaje);
			System.out.println("password1 = " + password);
			System.out.println("password2 = " + password1 );
			model.addAttribute("mensaje",mensaje);
			return new ModelAndView("CambiarPassword", "datos", u);
		}
		
		else if(password.equals(password1)) {
			int editar = ud.cambiarPassword(u);
			
			if(editar >0) {
				mensaje = "Password modificado";
				System.out.println(mensaje);
			}	
			else {
				mensaje = "No se modificó el password";
				System.out.println(mensaje);
			}	

			mensajes.addFlashAttribute("mensaje",mensaje);
			return new ModelAndView("redirect:/VerUsuarios");
		}
		else {
			mensaje = "Los password no coinciden";
			System.out.println(mensaje);
			System.out.println("password1 = " + password);
			System.out.println("password2 = " + password1 );
			model.addAttribute("mensaje",mensaje);
			return new ModelAndView("CambiarPassword", "datos", u);
		}
	}
	
}
