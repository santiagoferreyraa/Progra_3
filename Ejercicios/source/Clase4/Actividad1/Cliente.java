package Ejercicios.source.Clase4.Actividad1;

public class Cliente {
    private String nombre;
    private int scoring;
    private int idCliente;

    public int getScoring() {
        return scoring;
    }

    public Cliente(String nombre, int idCliente, int scoring) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente:\n" + nombre + ", " + scoring + ", " + idCliente;
    }
}
