package model;
import model.Vehiculo;

public class Auto extends Vehiculo{
	private int cantidadDePuertas;

	public Auto(String matricula, String marca, String modelo, int cantidadDePuertas) {
		super(matricula, marca, modelo);
		this.cantidadDePuertas = cantidadDePuertas;
	}
	
	public int getCantidadDePuertas() {
		return cantidadDePuertas;
	}
	
	public void getInfo() {
		System.out.println("Matricula: " + getMatricula());
		System.out.println("Marca: " + getMarca());
		System.out.println("Modelo: " + getModelo());
        System.out.println("Cantidad de Puertas: " + cantidadDePuertas);
	}
}
