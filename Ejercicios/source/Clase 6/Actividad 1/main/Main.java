//Desarrolla un programa que modele un sistema de seguidores en una red social
//utilizando un grafo representado con una lista de adyacencia. En este sistema,
//cada usuario puede seguir a otros usuarios, y queremos almacenar y consultar
//estas relaciones de manera eficiente.
//Especificaciones:
//Representación del Grafo:
//Utiliza una lista de adyacencia para representar el grafo. En esta representación,
//cada nodo (usuario) tiene una lista de nodos a los que sigue (usuarios que lo
//siguen).
//Estructuras de Datos:
//Usa una clase o estructura Usuario que tenga un identificador único (por ejemplo, un
//nombre o un número de ID).
//Utiliza un diccionario o un mapa para mantener la lista de adyacencia, donde cada clave
//es un Usuario y el valor asociado es una lista de usuarios que ese usuario sigue.
//Operaciones Requeridas:
//Agregar Usuario: Permite agregar un nuevo usuario al sistema.
//Seguir: Permite que un usuario siga a otro. Si el usuario ya sigue al destinatario, la
//operación no debe tener efecto.
//Dejar de Seguir: Permite que un usuario deje de seguir a otro. Si el usuario no sigue al
//destinatario, la operación no debe tener efecto.
//Lista de Seguidores: Permite consultar la lista de usuarios que sigue un usuario dado.
//Lista de Seguidores de: Permite consultar la lista de usuarios que siguen a un usuario
//dado.
package main;

import models.Usuario;
import grafo.RedSocial;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedSocial red = new RedSocial();

        // Crear usuarios
        Usuario user1 = new Usuario("Juan");
        Usuario user2 = new Usuario("Maria");
        Usuario user3 = new Usuario("Pedro");

        // Agregar usuarios al sistema
        red.agregarUsuario(user1);
        red.agregarUsuario(user2);
        red.agregarUsuario(user3);

        // Juan sigue a Maria y Pedro
        red.seguir(user1, user2);
        red.seguir(user1, user3);

        // Maria sigue a Pedro
        red.seguir(user2, user3);

        // Mostrar quién sigue a quién
        System.out.println("Usuarios que sigue Juan: ");
        for (Usuario usuario : red.listaSeguidores(user1)) {
            System.out.println(usuario.getNombre());
        }

        System.out.println("Usuarios que siguen a Pedro: ");
        for (Usuario usuario : red.listaSeguidoresDe(user3)) {
            System.out.println(usuario.getNombre());
        }

        // Dejar de seguir
        red.dejarDeSeguir(user1, user3);
        System.out.println("Usuarios que sigue Juan después de dejar de seguir a Pedro: ");
        for (Usuario usuario : red.listaSeguidores(user1)) {
            System.out.println(usuario.getNombre());
        }
    
	}	
	
}
