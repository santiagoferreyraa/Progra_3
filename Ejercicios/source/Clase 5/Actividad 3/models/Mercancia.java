package models;

public class Mercancia {
	private double peso;
	private double valor;
	private double ratio;
	
	public Mercancia(double peso, double valor) {
		this.peso = peso;
		this.valor = valor;
		this.ratio = valor / peso;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getValor() {
		return valor;
	}
	
	public double getRatio() {
		return ratio;
	}
}
