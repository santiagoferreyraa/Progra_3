package Ejercicios.source.Clase1.Actividad5;

public class Camion extends Vehiculo {
    private int capacidadDeCarga;

    @Override
    public void MostrarInformacion() {
        System.out.println(numeroDeMatricula);
        System.out.println(marca);
        System.out.println(modelo);
        System.out.println(capacidadDeCarga);
    }

    public Camion(int numeroDeMatricula, String marca, String modelo, int capacidadDeCarga) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public String toString() {
        return "Camión\n" +
                "Capacidad de carga: " + capacidadDeCarga +
                ", modelo: " + modelo +
                ", marca: " + marca +
                ", número de matrícula: " + numeroDeMatricula;
    }
}
