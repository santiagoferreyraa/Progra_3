//Implementación de un Grafo en una Matriz de Adyacencia
//Objetivo: Implementar un grafo utilizando una matriz de adyacencia en Java y
//realizar varias operaciones para manipular y consultar el grafo.
//Descripción del Problema:
//Dado un grafo dirigido, tu tarea es implementar las siguientes operaciones
//utilizando una matriz de adyacencia:
//Operaciones: Inicialización del Grafo, Agregar Arista, Eliminar Arista, Verificar
//Arista, Listar Adyacentes, Contar Grado de Entrada y Salida: Implementa métodos
//para contar el grado de salida (número de aristas que salen) y el grado de entrada
//(número de aristas que entran) de un vértice dado.
package main;

import grafo.Grafo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 3);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 4);
        grafo.mostrarMatriz();
        System.out.println("\n¿Existe arista (0 → 1)? " + grafo.existeArista(0, 1));
        System.out.println("¿Existe arista (1 → 3)? " + grafo.existeArista(1, 3));
        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(2);
        System.out.println("\nGrado de salida del nodo 0: " + grafo.gradoSalida(0));
        System.out.println("Grado de entrada del nodo 4: " + grafo.gradoEntrada(4));
        grafo.eliminarArista(0, 3);
        System.out.println("\nMatriz de Adyacencia después de eliminar arista (0 → 3):");
        grafo.mostrarMatriz();
	}

}
