package models;

public class Factura {
	private int contadorIdFactura = 0;
	private int idFactura;
	private int idCliente;
	private double importe;
	
	public Factura(int idCliente, double importe) {
		this.idFactura = contadorIdFactura++;
		this.idCliente = idCliente;
		this.importe = importe;
	}
	
	public int getIdFactura() {
		return idFactura;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public double getImporte() {
		return importe;
	}
}
