package cl.awakelab.springaprl.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.awakelab.springaprl.model.AccidentabilidadMapper;
import cl.awakelab.springaprl.model.Empresa;
import cl.awakelab.springaprl.model.EmpresaMapper;

public class EmpresaDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List <Empresa> listarEmpresas(){
		String sql = "SELECT idempresa, nombreempresa, direccion, contacto, telefono, mailcontacto, headcount FROM empresa ORDER BY idempresa";
		return template.query(sql, new EmpresaMapper());
		
	}
	
	public int editar(Empresa empresa) {
		String sql = "UPDATE empresa SET nombreempresa = ?, direccion = ?, contacto = ?, telefono = ?, mailcontacto = ? WHERE idempresa = ?";
		return template.update(sql, empresa.getNombreEmpresa(), empresa.getDireccion(), empresa.getContacto(), empresa.getTelefono(), empresa.getMailContacto(), empresa.getRutEmpresa());
	}

	public Empresa getById(String id) {
		String sql = "SELECT idempresa, nombreempresa, direccion, contacto, telefono, mailcontacto FROM empresa WHERE idempresa = ?";
		return template.queryForObject(sql, new Object[] {id}, new EmpresaMapper());
	}
	
	public int crear(Empresa empresa) {
		String sql ="INSERT INTO empresa (idempresa, nombreempresa, direccion, contacto, telefono, mailcontacto, headcount) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			int counter = template.update(sql, empresa.getRutEmpresa(), empresa.getNombreEmpresa(), empresa.getDireccion(), empresa.getContacto(), empresa.getTelefono(), empresa.getMailContacto(), empresa.getHeadCount());
			return counter;
		} catch (Exception e) {
			System.out.println("Error: Clase EmpresaDao, método crear");
			return 0;
		}
	}
	
	public int eliminar(Empresa empresa) {
		String sql = "DELETE FROM empresa WHERE idempresa = ?";
		try {
			return template.update(sql, empresa.getRutEmpresa());
		} catch(Exception e) {
			System.out.println("Eror: Clase EmpresaDao, método eliminar");
			e.printStackTrace();
			return 0;
		}
	}
	
	public List <Empresa> listaAccidentabilidad(){
		String sql = "SELECT idempresa, nombreempresa, count(id) as QAccidentes, (sum(empresa.headcount)/count(id)) as HeadCount, (count(id)/(sum(empresa.headcount)/count(id)))*100 as Accidentabilidad FROM empresa INNER JOIN registroaccidente using (idempresa) GROUP BY idempresa, nombreempresa";
		return template.query(sql, new AccidentabilidadMapper());
		
	}
	
}
