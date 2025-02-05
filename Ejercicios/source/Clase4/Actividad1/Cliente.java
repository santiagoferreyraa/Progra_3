package Ejercicios.source.Clase4.Actividad1;

public class Cliente {
    protected int id;
    protected String nombre;
    protected double scoring;

    public Cliente(int id, String nombre, double scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Id Cliente= " + id + "\nNombre= " + nombre + "\nScoring= " + scoring;
    }
}
