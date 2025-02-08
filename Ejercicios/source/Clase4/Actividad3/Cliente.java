package Ejercicios.source.Clase4.Actividad3;

public class Cliente {
    int id;
    String nombre;
    int scoring;
    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
    @Override
    public String toString() { 
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", scoring=" + scoring +
                '}';
    }
}
