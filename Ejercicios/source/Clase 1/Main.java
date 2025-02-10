package main;

import java.util.*;
import java.lang.*;
import java.io.*;
// The main method must be in a class named "Main".
public class Main {
	public static void main(String[] args) {
		int edad = 22;
		double altura = 1.75;
		char inicial = 'A';
		String ciudad = "Buenos Aires";
		//Operaciones
		int sumaEdad = edad + 3;
		double alturaDoble = altura * 2;
		String mensaje = "Tu inicial es " + inicial + ".";
		//Imprimir resultados
		System.out.println("La suma de tu edad más 3 es: " + sumaEdad);
		System.out.println("El doble de tu altura es: " + alturaDoble + " metros.");
		System.out.println(mensaje);
		System.out.println("Tu ciudad de residencia es: " + ciudad);
	}
}