package ec.ups.edu.appdis.g2.parqueadero.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "placa_vehiculo") //el nombre afecta en la BD
	private String placa;
	private String marca;
	private String color;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


}
