package cl.awakelab.springaprl.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.awakelab.springaprl.model.Accidente;

public class AccidenteDao {

JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Accidente> listarAccidentes(){
		return null;
	}
	
	public int crear(Accidente accidente) {
		String sql = "INSERT INTO registroaccidente (id, descripcionaccidente, fechaaccidente, horaaccidente, areaaccidente, idtipoaccidente, idusuario, idempresa, nombreaccidentado) "
				+ "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			int counter = template.update(sql, accidente.getDescripcionAccidente(), accidente.getFechaAccidente(), accidente.getHoraAccidente(), accidente.getAreaAccidente(), 
					accidente.getIdTipoAccidente(), accidente.getIdUsario(), accidente.getIdEmpresa(), accidente.getNombreAccidentado());
			return counter;
		} catch(Exception e) {
			System.out.println("Error: Clase AccidenteDao, método crear");
			e.printStackTrace();
			return 0;
		}
	}
}
