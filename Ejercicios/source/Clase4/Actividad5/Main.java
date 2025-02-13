package Ejercicios.source.Clase4.Actividad5;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static ArrayList<Atleta> BuscarMejor(HashMap<String, Atleta[]> tiempo) {
        ArrayList<Atleta> mejoresTiempos = new ArrayList<>();

        Object[] aux = tiempo.keySet().toArray();
        for (int i = 0; i < aux.length; i++) {
            Atleta[] atletas = tiempo.get(aux[i]);

            mergeSort(atletas);
            mejoresTiempos.add(atletas[0]);
        }
        return mejoresTiempos;
    }

    public static void mergeSort(Atleta[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        Atleta[] izquierda = new Atleta[medio];
        Atleta[] derecha = new Atleta[arreglo.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void merge(Atleta[] arreglo, Atleta[] izquierda, Atleta[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].getTiempo() <= derecha[j].getTiempo()) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {
        HashMap<String, Atleta[]> mejorTiempo = new HashMap<>();

        mejorTiempo.put("Senderismo", new Atleta[]{new Atleta("Juan", 40, "Senderismo"),
                                                   new Atleta("Jose", 45, "Senderismo"),
                                                   new Atleta("Julio", 38, "Senderismo"),
                                                   new Atleta("Santi", 41, "Senderismo")});

        mejorTiempo.put("Carretera", new Atleta[]{new Atleta("María", 234, "Carretera"),
                                                   new Atleta("Maxi", 523, "Carretera"),
                                                   new Atleta("Manuel", 233, "Carretera"),
                                                   new Atleta("Osvaldo", 132, "Carretera")});

        ArrayList<Atleta> mejoresTiempos = BuscarMejor(mejorTiempo);
        for (Atleta atleta : mejoresTiempos) {
            System.out.println(atleta.getCategoria() +
                    "\nNombre: " + atleta.getNombre() +
                    "\nTiempo: " + atleta.getTiempo() + "\n");
        }
    }
}
