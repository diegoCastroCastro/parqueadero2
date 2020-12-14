package ec.ups.edu.appdis.g2.parqueadero.negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g2.parqueadero.dao.ClienteDAO;
import ec.ups.edu.appdis.g2.parqueadero.dao.TicketDAO;
import ec.ups.edu.appdis.g2.parqueadero.dao.VehiculoDAO;
import ec.ups.edu.appdis.g2.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g2.parqueadero.modelo.Ticket;
import ec.ups.edu.appdis.g2.parqueadero.modelo.Vehiculo;

@Stateless //ejb
public class GestionTicketON implements GestionTicketONRemoto {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	@Inject
	private TicketDAO daoTicket;
	
	public boolean registrarTicket(Ticket ticket) throws Exception {
		try {
			Vehiculo vehiculo = ticket.getVehiculo();
			if (daoVehiculo.read(vehiculo.getPlaca()) != null) {
				daoVehiculo.update(vehiculo);
			} else {
				daoVehiculo.insertJPA(vehiculo);
			}
			ticket.setFechaIngreso(new Date());
			daoTicket.insert(ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Ticket salidaVehiculo (int idTicket) {
		
		return null;
	}
	
	public double calcularTiempo (int idTicket) {
		
		return 0;
	} 
	
	public Vehiculo buscarVehiculo (String placa) {
		
		return null;
	}
	
	public boolean registrarCliente (Cliente cliente) throws Exception
	{
		if (cliente.getDni().length()!=10) {
			throw new Exception("Cedula incorrecta");
		} 
		try {
			daoCliente.insertJPA(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		
		return true;
		
	}
	
	public boolean registrarVehiculo (Vehiculo vehiculo) throws Exception {
		if (validarPlaca(vehiculo.getPlaca())) {
			try {
				daoVehiculo.insertJPA(vehiculo);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error al registrar");
			}
		} else {
				throw new Exception("Numero de placa incorrecta");

		}
		return true;
	}

	private boolean validarPlaca(String placa) {
		if (placa.length()==7) {
			return true;
		}
		return false;
	}
	
	
	public List<Cliente> getClientesTipo1(){
		return daoCliente.getClientes();
	}
	
}
