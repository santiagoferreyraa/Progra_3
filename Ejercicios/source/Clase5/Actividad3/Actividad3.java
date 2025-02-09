package Ejercicios.Clase5.Actividad3;

import java.util.ArrayList;

public class Actividad3 {
    public static ArrayList<Mercancia> MaximizarValor(Mercancia[] mercancia, int pesoMax) {
        Mercancia[] aux = mercancia.clone();
        mergeSort(aux);
        ArrayList<Mercancia> resultado = new ArrayList<>();
        int suma = pesoMax;

        for (int i = aux.length - 1; i >= 0; i--) {
            if (suma == 0) {
                break;

            } else if (suma - aux[i].getPeso() >= 0) {
                resultado.add(aux[i]);
                suma -= aux[i].getPeso();

            } else {
                int porcentajePeso = aux[i].getPeso() / suma;
                aux[i].setValor(aux[i].getValor() / porcentajePeso);
                aux[i].setPeso(suma);
                resultado.add(aux[i]);
                suma = 0;
            }
        }

        if (suma > 0) {
            return null;

        } else {
            return resultado;
        }
    }

    public static void main(String[] args) {
        Mercancia[] mercancias = {new Mercancia(1000, 20), new Mercancia(100, 20),
                                  new Mercancia(500, 5), new Mercancia(200, 20)};
        ArrayList<Mercancia> resultado = MaximizarValor(mercancias, 50);
        for (Mercancia i : resultado) {
            System.out.println(i.getValor());
        }
    }

    public static void mergeSort(Mercancia[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        Mercancia[] izquierda = new Mercancia[medio];
        Mercancia[] derecha = new Mercancia[arreglo.length - medio];

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
    private static void merge(Mercancia[] arreglo, Mercancia[] izquierda, Mercancia[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].ValorPorPeso() <= derecha[j].ValorPorPeso()) {
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

class Mercancia {
    private int valor;
    private int peso;

    public int ValorPorPeso() {
        return valor / peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Mercancia(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }
}
