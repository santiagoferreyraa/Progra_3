package Actividad5;

import java.util.ArrayList;

public class ListaVehiculos {
    private ArrayList<Vehiculo> lista = new ArrayList<>();

    public void AgregarVehiculo(Vehiculo vehiculo) {
        lista.add(vehiculo);
    }

    public Vehiculo ObtenerVehiculo(int n) {
        Vehiculo vehiculo = lista.get(n);
        return vehiculo;
    }

    public void MostrarVehiculos() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(ObtenerVehiculo(i));
        }
    }
}