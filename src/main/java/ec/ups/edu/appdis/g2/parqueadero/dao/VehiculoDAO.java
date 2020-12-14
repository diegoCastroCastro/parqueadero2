package ec.ups.edu.appdis.g2.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.g2.parqueadero.modelo.Vehiculo;

@Stateless
public class VehiculoDAO {

	@Inject // llamamos al @Produce de la clase Resource.java
	private Connection con;

	@Inject //JPA
	private EntityManager em;
	
	public boolean insert (Vehiculo entity) throws Exception {
		String sql = "INSERT INTO vehiculo (placa_vehiculo, marca, color) VALUES "
				+ "(?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,  entity.getPlaca());
		ps.setString(2, entity.getPlaca());
		ps.setString(3, entity.getColor());
		
		ps.executeUpdate();
		ps.close();
		return true;
	}
	
	public boolean insertJPA (Vehiculo entity) throws SQLException{
		em.persist(entity);
		return true;
	}

	public boolean update (Vehiculo entity) {
		em.merge(entity);
		return true;
	}

	public Vehiculo read (String id) {
		try {
			Vehiculo v = em.find(Vehiculo.class, id);
			return v;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete (String id) {
		Vehiculo v = em.find(Vehiculo.class, id);
		em.remove(v);
		return true;
	}

}
