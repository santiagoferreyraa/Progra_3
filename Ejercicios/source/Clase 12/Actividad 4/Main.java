package main;

import models.Usuario;
import graph.Grafo;

public class Main {
    public static void main(String[] args) {
    	
        Grafo redSocial = new Grafo();

        redSocial.agregarUsuario(1, "Luciano");
        redSocial.agregarUsuario(2, "Agustín");
        redSocial.agregarUsuario(3, "Ignacio");
        redSocial.agregarUsuario(4, "Nicolas");
        redSocial.agregarUsuario(5, "Santi");

        redSocial.agregarAmistad(1, 2);  // Luciano y Agustín son amigos
        redSocial.agregarAmistad(1, 3);  // Luciano e Ignacio son amigos
        redSocial.agregarAmistad(2, 4);  // Agustín y Nicolas son amigos
        redSocial.agregarAmistad(3, 5);  // Ignacio y Santi son amigos
        redSocial.agregarAmistad(4, 5);  // Nicolas y Santi son amigos

        System.out.println("Recorrido DFS desde Alice:");
        redSocial.DFS(1);
        
        System.out.println();
        
        System.out.println("Recorrido BFS desde Alice:");
        redSocial.BFS(1);
    }
}
