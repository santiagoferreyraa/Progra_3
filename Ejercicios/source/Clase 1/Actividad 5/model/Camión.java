package model;
import model.Vehiculo;

public class Camión extends Vehiculo{
	private double capacidadDeCarga;
	
	public Camión(String matricula, String marca, String modelo, double capacidadDeCarga) {
		super(matricula, marca, modelo);
		this.capacidadDeCarga = capacidadDeCarga;
	}
	
	public double getCapacidadDeCarga(){
		return capacidadDeCarga;
	}
	
	public void getInfo() {
		System.out.println("Matricula: " + getMatricula());
		System.out.println("Marca: " + getMarca());
		System.out.println("Modelo: " + getModelo());
        System.out.println("Capacidad de Carga: " + capacidadDeCarga);
	}
}
