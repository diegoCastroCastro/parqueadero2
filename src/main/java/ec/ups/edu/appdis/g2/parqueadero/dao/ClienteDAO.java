package ec.ups.edu.appdis.g2.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.g2.parqueadero.modelo.Cliente;

@Stateless // ejb
public class ClienteDAO {

	@Inject // llamamos al @Produce de la clase Resource.java
	private Connection con;

	// JPA
	@Inject
	private EntityManager em;

	/**
	 * Insert con JPA
	 */
	public boolean insertJPA(Cliente entity) throws SQLException {
		em.persist(entity);
		return true;
	}
	
	/**
	 * Insert con JBC
	 */

	public boolean insert(Cliente entity) throws SQLException {

		String sql = "INSERT INTO Cliente (dni, email, nombre, tipo_documento)" + "VALUES (?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getDni());
		ps.setString(2, entity.getEmail());
		ps.setString(3, entity.getNombre());
		ps.setInt(4, entity.getTipoDocumento());

		ps.executeUpdate();
		ps.close();

		return true;
	}

	public boolean update(Cliente entity) {
		em.merge(entity);
		return true;
	}

	public Cliente read(int id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}

	public boolean delete(int id) {
		Cliente cliente = this.read(id);
		em.remove(cliente);
		return true;
	}
	
	public List<Cliente> getClientes(){
		String jpql = "SELECT c FROM c WHERE tipoDocumento=?1";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter(1, 1);
		return q.getResultList();
	}
		
}
