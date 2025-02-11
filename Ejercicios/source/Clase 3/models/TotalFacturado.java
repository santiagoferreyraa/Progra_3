package models;

public class TotalFacturado {
	private int idCliente;
	private String nombreCliente;
	private double importeTotal;
	
	public TotalFacturado(int idCliente, String nombreCliente, double importeTotal) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.importeTotal = importeTotal;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public double getImporteTotal(){
		return importeTotal;
	}
}
