package main;

import models.Mercancia;
import models.Resultado;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Mercancia> mercancias = new ArrayList<>();
		mercancias.add(new Mercancia(10, 15));
		mercancias.add(new Mercancia(5, 4));
		mercancias.add(new Mercancia(8, 20));
		mercancias.add(new Mercancia(6, 15));
		
		List<Resultado> resultados = mercanciaFraccionaria(mercancias, 15);
		for(Resultado resultado : resultados) {
			System.out.println("peso: " + resultado.getPeso() + "\nvalor: " + resultado.getValor() + "\nRatio: " + resultado.getRatio() + "\nPorcentaje Almacenado: " + resultado.getPorcentaje() + "\n");
		}
	}
	
	public static List<Resultado> mercanciaFraccionaria(List<Mercancia> mercancias, int capacidad) {
		if (capacidad == 0) return new ArrayList<>();

		List<Mercancia> copiaMercancias = new ArrayList<>(mercancias);
		Collections.sort(copiaMercancias, (a, b) -> Double.compare(b.getRatio(), a.getRatio()));
		
		List<Resultado> resultados = new ArrayList<>();
		
	    double valorTotal = 0.0;
        for (Mercancia mercancia : copiaMercancias) {
            if (capacidad == 0) break;
            
            double cantidad = Math.min(capacidad, mercancia.getPeso()); // Tomamos lo que entre
            capacidad -= cantidad; // Reducir capacidad
            resultados.add(new Resultado(mercancia.getPeso(), mercancia.getValor(), mercancia.getRatio(), cantidad / mercancia.getPeso()));
        } 
        
        return resultados;
	}

}
