package Ejercicios.source.Clase6.Actividad1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> grafo = new TreeMap<Integer, ArrayList<Integer>>();

        usuarios.addAll(List.of(
            new Usuario(1, "Juan"), 
            new Usuario(2, "Agustin"),
            new Usuario(3, "Santiago"),
            new Usuario(4, "Maximo")
        ));

        for (int i = 0; i < usuarios.size(); i++) {
            grafo.put(i, new ArrayList<Integer>());
        }
        
        grafo.get(0).add(2);
        grafo.get(0).add(3);
        grafo.get(1).add(2);
        grafo.get(2).add(3);
        grafo.get(2).add(0);        
        
        for (int i = 0; i < usuarios.size(); i++) {
            if (grafo.get(i).size() <= 0){
                System.out.println("Usuario " + usuarios.get(i).getNombre() + " no tiene amigos");
            } else { 
                System.out.print("Amigos de " + usuarios.get(i).getNombre() + ": ");
                for (int j = 0; j < grafo.get(i).size(); j++) {
                    System.out.print(usuarios.get(grafo.get(i).get(j)).getNombre() + " ");
                }
            }
            System.out.println();
        }
    }
}
