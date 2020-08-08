package cl.awakelab.springaprl.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.awakelab.springaprl.model.User;
import cl.awakelab.springaprl.model.UsuariosByIdMapper;
import cl.awakelab.springaprl.model.UserListMapper;
/**
 * Clase que contine el CRUD de los usuarios del sistema
 * @author Germán Illanes <illanes@gmail.com>
 * @author Carlos Quintanilla <kintagol@gmail.com>
 * @author Luis Torres <ltorresp@gmail.com>
 * @version 0.99
 */
public class UsuarioDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/**
	 * Método que lista los usuarios existentes en la base de datos del sistema
	 * @return lista de usuarios
	 */
	public List <User> listarUsuarios(){
		String sql = "SELECT idusuario, nombre, idempresa, nombreempresa, nombreperfil FROM usuario INNER JOIN empresa USING(idempresa) INNER JOIN perfil USING (idperfil) ORDER BY nombre";
		return template.query(sql, new UserListMapper());
	}
	
	
	/**
	 * Método que permite editar los campos nombre, perfil y empresa de un usuario existente en el sistema
	 * @param user
	 * @return cantidad de filas actualizadas
	 */
	public int editar(User user) {
		String sql = "UPDATE usuario SET nombre = ?,  idperfil = ?, idempresa = ? WHERE idusuario = ?";
		try {
			return template.update(sql, user.getNombre(), user.getPerfil(), user.getEmpresa(), user.getId());
		}catch(Exception e) {
			System.out.println("Error: Clase UserDao, método Editar");
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/**
	 * Método que permite obtener un usuario por medio de su id
	 * @param id
	 * @return objeto mapeado
	 */
	public User getById(String id){    
	    String sql="SELECT * FROM usuario WHERE idusuario = ?";    
	    return template.queryForObject(sql, new Object[]{id},new UsuariosByIdMapper());    
	}
	
	/**
	 * Método que permite crear nuevos usuarios en el sistema
	 * @param user
	 * @return cantidad de filas ingresadas
	 */
	public int crear(User user) {
		String sql = "INSERT INTO usuario (idusuario, nombre, password, idperfil, idempresa) VALUES (?, ?, ?, ?, ?)";
		try {
			int counter = template.update(sql, user.getId(), user.getNombre(), user.getPassword(), user.getPerfil(), user.getEmpresa());
			return counter;
		} catch (Exception e) {
			System.out.println("Error: Clase UserDao, método crearUser");
			e.printStackTrace();
			return 0;
		}
		 
	}
	
	/**
	 * Método que permite eliminar un usuario del sistema
	 * @param user
	 * @return cantidad de filas eliminadas
	 */
	public int eliminar(User user) {
		String sql = "DELETE FROM usuario WHERE idusuario = ?";
		try {
			return template.update(sql, user.getId());
		}catch(Exception e) {
			System.out.println("Error: Clase UserDao, método Eliminar");
			return 0;
		}
		
	}
	/**
	 * Método que permite cambiar el password de un usuario
	 * @param user
	 * @return cantidad de filas actualizadas
	 */
	public int cambiarPassword(User user) {
		String sql = "UPDATE usuario SET password = ? WHERE idusuario = ?";
		try {
			return template.update(sql, user.getPassword(), user.getId());
		}catch(Exception e) {
			System.out.println("Error: Clase UserDao, método cambiarPassword");
			return 0;
		}
		
	}

}
