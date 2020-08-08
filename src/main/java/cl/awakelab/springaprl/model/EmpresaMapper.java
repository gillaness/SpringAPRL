package cl.awakelab.springaprl.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpresaMapper implements RowMapper<Empresa> {
	public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Empresa(
				rs.getString("idempresa"),
				rs.getString("nombreempresa"),
				rs.getString("direccion"),
				rs.getString("contacto"),
				rs.getString("telefono"),
				rs.getString("mailcontacto"),
				rs.getInt("headcount")
				);
	}

}
