package ec.ups.edu.appdis.g2.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g2.parqueadero.modelo.Cliente;

@Stateless //ejb
public class ClienteDAO {
	
	@Inject //llamamos al @Produce de la clase Resource.java
	private Connection con;

	public boolean insert (Cliente entity) throws SQLException {
		
		String sql = "INSERT INTO Cliente (dni, email, nombre, tipoDocumento)"
				+ "VALUES (?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getDni());
		ps.setString(2, entity.getEmail());
		ps.setString(3, entity.getNombre());
		ps.setInt(4, entity.getTipoDocumento());
		
		ps.executeUpdate();
		ps.close();
		
		
		return true;
	}

	public boolean update (Cliente entity) {

		return true;
	}

	public Cliente read (int id) {

		return null;
	}

	public boolean delete (int id) {

		return true;
	}

}
