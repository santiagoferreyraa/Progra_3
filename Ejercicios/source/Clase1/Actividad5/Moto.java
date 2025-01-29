package Actividad5;

public class Moto extends Vehiculo {
    enum TipoDeMoto {
        Deportiva,
        Urbana
    }

    private TipoDeMoto tipoDeMoto;

    @Override
    public void MostrarInformacion() {
        System.out.println(numeroDeMatricula);
        System.out.println(marca);
        System.out.println(modelo);
        System.out.println(tipoDeMoto);
    }

    public Moto(int numeroDeMatricula, String marca, String modelo, TipoDeMoto tipoDeMoto) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoDeMoto = tipoDeMoto;
    }

    @Override
    public String toString() {
        return "Moto\n" +
                "Tipo de moto: " + tipoDeMoto +
                ", modelo: " + modelo +
                ", marca: " + marca +
                ", número de matrícula: " + numeroDeMatricula;
    }
}