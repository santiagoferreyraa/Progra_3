package Ejercicios.Clase5.Actividad2;

import java.util.ArrayList;

public class Actividad2 {
    public static ArrayList<Comprobante> CambioMonedaExtranjera(Comprobante[] comprobantes, int cantidad) {
        Comprobante[] aux = comprobantes.clone(); // O(1 + n)
        mergeSort(aux); // O(n.log(n))
        ArrayList<Comprobante> resultado = new ArrayList<>(); // O(1)
        int suma = cantidad; // O(1)

        for (int i = aux.length - 1; i >= 0; i--) { // O(3 + 3n)
            if (suma - aux[i].getValor() >= 0) { // O(3n)
                resultado.add(aux[i]); // O(n)
                suma -= aux[i].getValor(); // O(3n)

            } else if (suma == 0) {
                break;
            }
        }

        if (suma > 0) { // O(1)
            return null; // O(1)

        } else {
            return resultado;
        }

        // 1 + n + n.log(n) + 1 + 1 + 3 + 3n + 3n + n + 3n + 1 + 1 = 8 + 11n + n.log(n) <= c.n
        //                                                            8/n + 11 + log(n) <= c
        //                                                                           n0 == 1
        //                                                                   8 + 11 + 0 <= c
        //                                                                           19 <= c
        // f(n) = 8 + 11n + n.log(n) pertenece a O(n.log(n)) para c = 19 y n0 = 1.
    }

    public static void main(String[] args) {
        Comprobante[] comprobantes = {new Moneda(1), new Cheque(10), new Bono(2)};
        ArrayList<Comprobante> resultado = CambioMonedaExtranjera(comprobantes, 13);
        for (Comprobante i : resultado) {
            System.out.print(i.getValor() + " ");
        }
    }

    public static void mergeSort(Comprobante[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        Comprobante[] izquierda = new Comprobante[medio];
        Comprobante[] derecha = new Comprobante[arreglo.length - medio];

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
    private static void merge(Comprobante[] arreglo, Comprobante[] izquierda, Comprobante[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].getValor() <= derecha[j].getValor()) {
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

}

abstract class Comprobante {
    protected int valor;

    public int getValor() {
        return valor;
    }
}

class Moneda extends Comprobante {
    public Moneda(int valor) {
        this.valor = valor;
    }
}

class Cheque extends Comprobante {
    public Cheque(int valor) {
        this.valor = valor;
    }
}

class Bono extends Comprobante {
    public Bono(int valor) {
        this.valor = valor;
    }
}
