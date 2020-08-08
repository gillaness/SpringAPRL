package cl.awakelab.springaprl.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccidentabilidadMapper implements RowMapper<Empresa> {
	public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Empresa(
				rs.getString("idempresa"),
				rs.getString("nombreempresa"),
				rs.getFloat("accidentabilidad"),
				rs.getInt("HeadCount"),
				rs.getInt("QAccidentes")
				);
		
		
	}

}
