package Ejercicios.Clase4.Actividad5;

public class Atleta {
    private String nombre;
    private String categoria;
    private int tiempo;

    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getCategoria() {
        return categoria;
    }

    public Atleta(String nombre, int tiempo, String categoria) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.categoria = categoria;
    }
}
