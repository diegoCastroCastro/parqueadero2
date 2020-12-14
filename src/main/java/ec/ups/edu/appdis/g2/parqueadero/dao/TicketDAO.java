package ec.ups.edu.appdis.g2.parqueadero.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.g2.parqueadero.modelo.Ticket;

@Stateless
public class TicketDAO {

	@Inject
	private EntityManager em;
	
	public boolean insert (Ticket entity) {
		em.persist(entity);
		return true;
	}

	public boolean update (Ticket entity) {
		em.merge(entity);
		return true;
	}

	public Ticket read (int id) {
		Ticket ticket =  em.find(Ticket.class, id);
		return ticket;
	}

	public boolean delete (int id) {
		Ticket ticket =  em.find(Ticket.class, id);
		em.remove(ticket);
		return true;
	}

}
