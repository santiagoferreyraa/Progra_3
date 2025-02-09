package Ejercicios.source.Clase5.Actividad2;

public abstract class Comprobante {
    int valor;

    public Comprobante(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "($" + valor + ")";
    }
}
