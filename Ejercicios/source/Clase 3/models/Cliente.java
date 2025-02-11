package models;

public class Cliente {
	private static int contadorIdCliente = 1;
	private int idCliente;
	private String nombreCliente;
	
	public Cliente(String nombreCliente) {
		this.idCliente = contadorIdCliente++;
		this.nombreCliente = nombreCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
}
