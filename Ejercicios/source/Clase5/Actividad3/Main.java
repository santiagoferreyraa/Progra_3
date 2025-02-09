package Ejercicios.source.Clase5.Actividad3;
import java.util.List;

public class Main {
    public static double maximizarValorTotal( List<Elementos> items, int capacidad){
        /* 
        Collections.sort(items, new Comparator<Elementos>(){
            @Override
            public int compare(Elementos o1, Elementos o2) {
                return Double.compare(o2.valorPorPeso, o1.valorPorPeso);
            }
        });
        */

        items.sort((a,b) -> Double.compare(a.valorPorPeso, b.valorPorPeso)); 
        
                                        // TODO: Arreglar el sort!         
        double total = 0;
        for(Elementos item : items){
            if(capacidad >= item.peso){
                capacidad -= item.peso;
                total += item.valor;
            } else {
                total += item.valorPorPeso * capacidad;
                break;
            }
        }
        
        return total;
    }

    public static void main(String[] args) {
        List<Elementos> items = List.of(
                new Elementos(20, 50),
                new Elementos(30, 100),
                new Elementos(10, 60)
        );
        
        int capacidad = 120;
        
        System.out.println("Valor total máximo: " + maximizarValorTotal(items, capacidad));
    }    
}
