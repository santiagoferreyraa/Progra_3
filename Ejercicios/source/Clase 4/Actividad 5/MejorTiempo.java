//Ejercicio: Campeonato de Atletismo - Encontrar los Mejores Tiempos por
//Categoría
//Descripción:
//Se organiza un campeonato de atletismo con varias categorías. Cada corredor
//tiene un nombre, una categoría y un tiempo en segundos registrado en su carrera.
//Se desea encontrar el mejor tiempo (mínimo) y el nombre del corredor
//correspondiente para cada categoría, utilizando la técnica de Divide y Vencerás.
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MejorTiempo {
	
    public static void main(String[] args) {
        
        ArrayList<Corredor> corredores = new ArrayList<>();
        corredores.add(new Corredor("Junior", "Juan", 12.2));
        corredores.add(new Corredor("Senior", "Pedro", 15.90));
        corredores.add(new Corredor("Senior", "Luciano", 16.2));
        corredores.add(new Corredor("Senior", "Joaquin", 10.90));
        corredores.add(new Corredor("Master", "Agustin", 10.2));
        corredores.add(new Corredor("Senior", "Lolo", 10.15));
        corredores.add(new Corredor("Junior", "Rocio", 12.2));
        corredores.add(new Corredor("Senior", "Nicolas", 13.5));
        corredores.add(new Corredor("Junior", "Nacho", 15.2));
        corredores.add(new Corredor("Master", "Franco", 16.90));

        HashMap<String,ArrayList<Corredor>> corredorPorCategoria = new HashMap<>();
        for (Corredor corredor : corredores) {
            if(!corredorPorCategoria.containsKey(corredor.categoria)) {
                ArrayList<Corredor> ncorredores  = new ArrayList<>();
                corredorPorCategoria.put(corredor.categoria, ncorredores);
            }
            corredorPorCategoria.get(corredor.categoria).add(corredor);
        }

        for (ArrayList<Corredor> ncorredores : corredorPorCategoria.values()) {
            System.out.println(buscarScoringMaximo(ncorredores));
        }

    }

    private static Corredor buscarScoringMaximo(List<Corredor> corredores) {
        return buscarScoringMaximo(corredores, 0, corredores.size()-1);
    }    
    private static Corredor buscarScoringMaximo(List<Corredor> corredores, int inicio, int fin) {
        if (inicio == fin) {
            return corredores.get(inicio);
        }

        int medio = (inicio + fin) / 2;
        Corredor maxIzquierda = buscarScoringMaximo(corredores, inicio, medio);
        Corredor maxDerecha = buscarScoringMaximo(corredores, medio + 1, fin);
 
        return maxIzquierda.tiempo > maxDerecha.tiempo ? maxIzquierda : maxDerecha;
  
    }

}

class Corredor {
    String categoria;
    String nombre;
    double tiempo;
    public Corredor(String categoria, String nombre, double tiempo) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    @Override
    public String toString() {
        return "Corredor [categoria=" + categoria + ", nombre=" + nombre + ", tiempo=" + tiempo + "]";
    }
       
}