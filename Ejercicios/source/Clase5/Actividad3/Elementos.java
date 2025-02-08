package Ejercicios.source.Clase5.Actividad3;

public class Elementos {
    int peso;
    int valor;
    double valorPorPeso;
    
    public Elementos(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
        this.valorPorPeso = (double) valor / peso;
    }
}
