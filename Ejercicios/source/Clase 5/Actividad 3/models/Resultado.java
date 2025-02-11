package models;

public class Resultado {
	private double peso;
	private double valor;
	private double ratio;
	private double porcentaje;
	
	public Resultado(double peso, double valor, double ratio, double porcentaje) {
		this.peso = peso;
		this.valor = valor;
		this.ratio = ratio;
		this.porcentaje = porcentaje;
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
	
	public double getPorcentaje() {
		return porcentaje;
	}
}
