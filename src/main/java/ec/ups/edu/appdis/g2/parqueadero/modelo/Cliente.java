package ec.ups.edu.appdis.g2.parqueadero.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //jpa
public class Cliente implements Serializable{

	@Id //jpa
	private String dni;
	private int tipoDocumento;
	private String nombre;
	private String email;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
