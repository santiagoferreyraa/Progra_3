package Ejercicios.source.Clase4.Actividad2;

public class MaximosDyC {

    public static int[] encontrarDosMayores(int[] numeros, int ini, int fin) {
        
        // Queda un elemento
        if (ini == fin) return new int[]{numeros[ini], Integer.MIN_VALUE}; 
        // Quedan dos elementos
        if (fin - ini == 1) return numeros[ini] > numeros[fin] ? new int[]{numeros[ini], numeros[fin]} : new int[]{numeros[fin], numeros[ini]};
        
        int medio = (ini + fin) / 2;
        int[] izq = encontrarDosMayores(numeros, ini, medio);
        int[] der = encontrarDosMayores(numeros, medio + 1, fin);

        int mayor1, mayor2;
        /* Determino el mayor entre ambas listas
        Tengo [8,5] y [5,3]
           Si  ^    >  ^ -> Devuelvo el primero de la lista izquierda
           Ahora busco el segundo mayor que puede ser el primero de la derecha o el segundo de la izquierda
           Si en cambio, el mas grande al principio es der[0], entonces el segundo mayor puede ser el 
           izq[0] o der[1].
        */
        if (izq[0] > der[0]) {
            mayor1 = izq[0]; 
            mayor2 = Math.max(izq[1], der[0]); 
        } else {
            mayor1 = der[0];
            mayor2 = Math.max(der[1], izq[0]);
        }

        return new int[]{mayor1, mayor2};
    }

    public static void main(String[] args) {
        int[] numeros = {1,8,14,19,34,20,88,52,79};
        int[] mayores = encontrarDosMayores(numeros, 0, numeros.length - 1);

        System.out.println("Los dos números mayores son: " + mayores[0] + " y " + mayores[1]);
    }
}
