package Actividad5;

public class Auto extends Vehiculo {
    private int cantidadDePuertas;

    @Override
    public void MostrarInformacion() {
        System.out.println(numeroDeMatricula);
        System.out.println(marca);
        System.out.println(modelo);
        System.out.println(cantidadDePuertas);
    }

    public Auto(int numeroDeMatricula, String marca, String modelo, int cantidadDePuertas) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadDePuertas = cantidadDePuertas;
    }

    @Override
    public String toString() {
        return "Auto\n" +
                "Cantidad de puertas: " + cantidadDePuertas +
                ", modelo: " + modelo +
                ", marca: " + marca +
                ", número de matrícula: " + numeroDeMatricula;
    }
}
