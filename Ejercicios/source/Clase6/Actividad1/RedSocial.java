package Ejercicios.source.Clase6.Actividad1;

import java.util.*;

class Usuario {
    private int id;
    private String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nombre;
    }
}

public class RedSocial {
    private Map<Usuario, Set<Usuario>> grafo;

    public RedSocial() {
        this.grafo = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        grafo.putIfAbsent(usuario, new HashSet<>());
    }

    public void seguir(Usuario seguidor, Usuario seguido) {
        grafo.putIfAbsent(seguidor, new HashSet<>());
        grafo.putIfAbsent(seguido, new HashSet<>());
        grafo.get(seguidor).add(seguido);
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (grafo.containsKey(seguidor)) {
            grafo.get(seguidor).remove(seguido);
        }
    }

    public Set<Usuario> obtenerSeguidos(Usuario usuario) {
        return grafo.getOrDefault(usuario, new HashSet<>());
    }

    public Set<Usuario> obtenerSeguidores(Usuario usuario) {
        Set<Usuario> seguidores = new HashSet<>();
        for (Map.Entry<Usuario, Set<Usuario>> entry : grafo.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }

    public void mostrarRed() {
        for (Map.Entry<Usuario, Set<Usuario>> entry : grafo.entrySet()) {
            System.out.println("Usuario " + entry.getKey() + " sigue a: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Usuario u1 = new Usuario(1, "Juan");
        Usuario u2 = new Usuario(2, "José");
        Usuario u3 = new Usuario(3, "Carlos");

        RedSocial red = new RedSocial();
        red.agregarUsuario(u1);
        red.agregarUsuario(u2);
        red.agregarUsuario(u3);
        red.seguir(u1, u2);
        red.seguir(u1, u3);
        red.seguir(u2, u3);
        red.dejarDeSeguir(u1, u3);

        red.mostrarRed();
        System.out.println("Seguidores de " + u3.getNombre() + ": " + red.obtenerSeguidores(u3));
    }
}
