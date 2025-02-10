package Ejercicios.source.Clase4.Actividad5;

import java.util.ArrayList;
import java.util.HashMap;

class Deportista {
    private String nombre;
    private String disciplina;
    private int marca;

    public Deportista(String nombre, int marca, String disciplina) {
        this.nombre = nombre;
        this.marca = marca;
        this.disciplina = disciplina;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerMarca() {
        return marca;
    }

    public String obtenerDisciplina() {
        return disciplina;
    }
}

public class Campeonato {

    public static ArrayList<Deportista> encontrarMejores(HashMap<String, Deportista[]> registros) {
        ArrayList<Deportista> mejoresResultados = new ArrayList<>();

        for (String clave : registros.keySet()) {
            Deportista[] participantes = registros.get(clave);

            ordenarParticipantes(participantes);
            mejoresResultados.add(participantes[0]);
        }
        return mejoresResultados;
    }

    public static void ordenarParticipantes(Deportista[] lista) {
        if (lista.length < 2) {
            return;
        }

        int mitad = lista.length / 2;
        Deportista[] parteIzquierda = new Deportista[mitad];
        Deportista[] parteDerecha = new Deportista[lista.length - mitad];

        System.arraycopy(lista, 0, parteIzquierda, 0, mitad);
        System.arraycopy(lista, mitad, parteDerecha, 0, lista.length - mitad);

        ordenarParticipantes(parteIzquierda);
        ordenarParticipantes(parteDerecha);

        combinarListas(lista, parteIzquierda, parteDerecha);
    }

    private static void combinarListas(Deportista[] lista, Deportista[] izquierda, Deportista[] derecha) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].obtenerMarca() <= derecha[j].obtenerMarca()) {
                lista[k++] = izquierda[i++];
            } else {
                lista[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            lista[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            lista[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {
        HashMap<String, Deportista[]> resultados = new HashMap<>();

        resultados.put("Trail", new Deportista[]{
                new Deportista("Juan", 40, "Trail"),
                new Deportista("Maximo", 45, "Trail")
        });

        resultados.put("Ruta", new Deportista[]{
                new Deportista("Agustin", 234, "Ruta"),
                new Deportista("Santiago", 523, "Ruta")
        });

        ArrayList<Deportista> ganadores = encontrarMejores(resultados);

        for (Deportista participante : ganadores) {
            System.out.println("Disciplina: " + participante.obtenerDisciplina() +
                    "\nNombre: " + participante.obtenerNombre() +
                    "\nMarca: " + participante.obtenerMarca() + "\n");
        }
    }
}
