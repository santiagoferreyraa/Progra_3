//Objetivo: Aplicar la técnica de Divide y Vencerás en una lista de clientes con id,
//nombre y scoring, buscando los dos clientes con los scoring máximos.
//Tareas:
//Resolver mediante pseudocódigo
//Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas
//matemáticas) para indicar la complejidad algorítmica.
//Implementar en java
package main;
import java.util.ArrayList;
import java.util.List;
 
class Cliente {
     int id;
     String nombre;
     int scoring;
 
     public Cliente(int id, String nombre, int scoring) {
         this.id = id;
         this.nombre = nombre;
         this.scoring = scoring;
     }
 }
 
 public class DosClientesMaxScore {
 
     public static class Resultado {
         Cliente mayor;
         Cliente segundoMayor;
 
         public Resultado(Cliente mayor, Cliente segundoMayor) {
             this.mayor = mayor;
             this.segundoMayor = segundoMayor;
         }
     }
 
     public static Resultado encontrarDosClientesMaximoScoring(List<Cliente> listaClientes, int inicio, int fin) {
         // Caso base: Si la lista tiene solo un elemento
         if (inicio == fin) {
             return new Resultado(listaClientes.get(inicio), null);
         }
 
         // Caso base: Si la lista tiene solo dos elementos
         if (fin - inicio == 1) {
             if (listaClientes.get(inicio).scoring > listaClientes.get(fin).scoring) {
                 return new Resultado(listaClientes.get(inicio), listaClientes.get(fin));
             } else {
                 return new Resultado(listaClientes.get(fin), listaClientes.get(inicio));
             }
         }
 
         // Dividir: Calcular el punto medio de la lista
         int medio = (inicio + fin) / 2;
 
         // Conquistar: Llamar recursivamente a la función para las dos mitades de la lista
         Resultado izquierda = encontrarDosClientesMaximoScoring(listaClientes, inicio, medio);
         Resultado derecha = encontrarDosClientesMaximoScoring(listaClientes, medio + 1, fin);
 
         // Combinar: Encontrar los dos mayores entre las dos mitades
         Cliente mayor, segundoMayor;
         if (izquierda.mayor.scoring > derecha.mayor.scoring) {
             mayor = izquierda.mayor;
             if (izquierda.segundoMayor == null || derecha.mayor.scoring > izquierda.segundoMayor.scoring) {
                 segundoMayor = derecha.mayor;
             } else {
                 segundoMayor = izquierda.segundoMayor;
             }
         } else {
             mayor = derecha.mayor;
             if (derecha.segundoMayor == null || izquierda.mayor.scoring > derecha.segundoMayor.scoring) {
                 segundoMayor = izquierda.mayor;
             } else {
                 segundoMayor = derecha.segundoMayor;
             }
         }
 
         return new Resultado(mayor, segundoMayor);
     }
 
     public static void main(String[] args) {
         // Ejemplo de uso
         List<Cliente> listaClientes = new ArrayList<>();
         listaClientes.add(new Cliente(1, "Agustin", 100));
         listaClientes.add(new Cliente(2, "Luciano", 60));
         listaClientes.add(new Cliente(3, "Felipe", 70));
         listaClientes.add(new Cliente(4, "Nacho", 80));
         listaClientes.add(new Cliente(5, "Nico", 40));
         listaClientes.add(new Cliente(6, "Santiago", 90));
         listaClientes.add(new Cliente(7, "Franco", 95));
         listaClientes.add(new Cliente(8, "Lucio", 99));
         listaClientes.add(new Cliente(9, "Ricardo", 10));
  
         // Llamar a la función
         int inicio = 0;
         int fin = listaClientes.size() - 1;
         Resultado resultado = encontrarDosClientesMaximoScoring(listaClientes, inicio, fin);
 
         // Imprimir los resultados
         System.out.println("Los dos clientes con mayor scoring son:");
         System.out.println("Mayor: ID: " + resultado.mayor.id + ", Nombre: " + resultado.mayor.nombre + ", Scoring: " + resultado.mayor.scoring);
        if (resultado.segundoMayor != null) {
             System.out.println("Segundo mayor: ID: " + resultado.segundoMayor.id + ", Nombre: " + resultado.segundoMayor.nombre + ", Scoring: " + resultado.segundoMayor.scoring);
         } else {
             System.out.println("Segundo mayor: No hay");
         }
     }
 }