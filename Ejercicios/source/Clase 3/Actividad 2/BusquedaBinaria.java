//Utilizar la implementación de la búsqueda binaria que está en el repo de la
//materia, para buscar un elemento en un array ordenado
package main;

public class BusquedaBinaria {
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        return busquedaBinariaRecursiva(arreglo, objetivo, 0, arreglo.length - 1);
    }

    private static int busquedaBinariaRecursiva(int[] arreglo, int objetivo, int izquierda, int derecha) {
        // Caso base: si los límites se cruzan, el elemento no está en el arreglo
        if (izquierda > derecha) {
            return -1;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        // Si el objetivo está en el medio, devolver el índice
        if (arreglo[medio] == objetivo) {
            return medio;
        }

        // Si el objetivo es menor, buscar en la mitad izquierda
        if (arreglo[medio] > objetivo) {
            return busquedaBinariaRecursiva(arreglo, objetivo, izquierda, medio - 1);
        }

        // Si el objetivo es mayor, buscar en la mitad derecha
        return busquedaBinariaRecursiva(arreglo, objetivo, medio + 1, derecha);
    }

    public static void main(String[] args) {
        int[] arreglo = {3, 5, 6, 7, 9, 15, 21};
        int objetivo = 5;
        int resultado = busquedaBinaria(arreglo, objetivo);
        System.out.println("Índice del objetivo: " + resultado);
    }
}