package Ejercicios.source.Clase12.Actividad4;

public class Usuario {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
