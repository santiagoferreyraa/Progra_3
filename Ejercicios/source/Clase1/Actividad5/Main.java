package Ejercicios.source.Clase1.Actividad5;

public class Main {
    public static void main(String[] args) {
        Camion camion = new Camion(23,"Ford","X34",400);
        Auto auto = new Auto(234,"Fiat","Palio",4);
        Moto moto = new Moto(2356,"Yamaha","XER4", Moto.TipoDeMoto.Deportiva);

        ListaVehiculos listaVehiculos = new ListaVehiculos();

        listaVehiculos.AgregarVehiculo(camion);
        listaVehiculos.AgregarVehiculo(moto);
        listaVehiculos.AgregarVehiculo(auto);

        listaVehiculos.MostrarVehiculos();
    }
}