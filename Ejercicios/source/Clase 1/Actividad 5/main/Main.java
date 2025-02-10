package main;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 4);
        Camión camion1 = new Camión("XYZ789", "Mercedes", "Actros", 15.5);
        Moto moto1 = new Moto("MOTO123", "Yamaha", "MT-07", "Deportiva");
        
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto1);
        vehiculos.add(camion1);
        vehiculos.add(moto1);
        
        System.out.println("Información de los vehículos:");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.getInfo();
            System.out.print("\n");
        }
	}

}
