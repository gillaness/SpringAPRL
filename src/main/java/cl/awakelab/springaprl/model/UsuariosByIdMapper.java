package cl.awakelab.springaprl.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsuariosByIdMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(
				rs.getString("idusuario"),
				rs.getString("nombre"),
				rs.getString("password"),
				rs.getInt("idperfil"),
				rs.getInt("idempresa")
				);
	}

}
