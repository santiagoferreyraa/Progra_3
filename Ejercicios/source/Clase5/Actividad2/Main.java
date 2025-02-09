package Ejercicios.source.Clase5.Actividad2;
import java.util.*;


public class Main {
    public static List<Comprobante> comprobantesMinimos(List<Comprobante> comprobantes, int monto) {
        
        comprobantes.sort((a, b) -> Integer.compare(b.valor, a.valor));
        List<Comprobante> arr = new ArrayList<>();
        int total = 0;

        for (Comprobante c : comprobantes) {
            while (total + c.valor <= monto) {
                arr.add(c);
                total += c.valor;
            }
            if (total == monto) {
                return arr;
            }
        }

        throw new IllegalArgumentException("Con los comprobantes disponibles no alcanzan");
    }

    
    public static void main(String[] args) {
        List<Comprobante> comprobantes = Arrays.asList(
                new Moneda(1),
                new Moneda(5),
                new Moneda( 10),
                new Moneda(50),
                new Bono(500),
                new Bono(350),
                new Cheque(400),
                new Cheque(150)
        );

        System.out.println("Comprobantes seleccionados: " + comprobantesMinimos(comprobantes, 753));
    }
}

