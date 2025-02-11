package model;
import model.Vehiculo;

public class Moto extends Vehiculo{
	private String tipoDeMoto;
	
	public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
		super(matricula, marca, modelo);
		this.tipoDeMoto = tipoDeMoto;
	}
	
	public String getTipoDeMoto() {
		return tipoDeMoto;
	}
	
	public void getInfo() {
		System.out.println("Matricula: " + getMatricula());
		System.out.println("Marca: " + getMarca());
		System.out.println("Modelo: " + getModelo());
        System.out.println("Tipo de Moto: " + tipoDeMoto);
	}
}
