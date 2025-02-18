package Ejercicios.source.Clase12.Actividad4;

public class Main {
    public static void main(String[] args) {
        GrafoRedSocial redSocial = new GrafoRedSocial();

        Usuario usuario1 = new Usuario("Santi",1);
        Usuario usuario2 = new Usuario("Juan",2);
        Usuario usuario3 = new Usuario("Manu",3);
        Usuario usuario4 = new Usuario("Leo",4);
        Usuario usuario5 = new Usuario("Pablo",5);

        redSocial.agregarUsuarios(usuario1);
        redSocial.agregarUsuarios(usuario2);
        redSocial.agregarUsuarios(usuario3);
        redSocial.agregarUsuarios(usuario4);
        redSocial.agregarUsuarios(usuario5);

        redSocial.conectarUsuarios(usuario1, usuario2);
        redSocial.conectarUsuarios(usuario1, usuario3);
        redSocial.conectarUsuarios(usuario2, usuario3);
        redSocial.conectarUsuarios(usuario3, usuario4);
        redSocial.conectarUsuarios(usuario3, usuario5);
        redSocial.conectarUsuarios(usuario5, usuario4);

        redSocial.BFS(usuario1);
        System.out.println();
        redSocial.DFS(usuario1);
    }
}
