package ec.ups.edu.appdis.g2.parqueadero.negocio;

import java.util.List;

import javax.ejb.Remote;

import ec.ups.edu.appdis.g2.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g2.parqueadero.modelo.Ticket;
import ec.ups.edu.appdis.g2.parqueadero.modelo.Vehiculo;

@Remote
public interface GestionTicketONRemoto {
	
	public boolean registrarCliente (Cliente cliente) throws Exception;
	public boolean registrarVehiculo (Vehiculo vehiculo) throws Exception;
	public List<Cliente> getClientesTipo1();
	public boolean registrarTicket(Ticket ticket) throws Exception;
}
