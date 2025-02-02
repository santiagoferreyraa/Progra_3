package Ejercicios.source.Clase2.Actividad1;
public class Promedio {
    public static double promedio(int[][] matriz) {
        int sumaTotal = 0;          // 1
        int cont = 0;               // 1
        for (int i = 0; i < matriz.length; i++) {       // 1 + n + 1 + 2n -> 2 + 3n
            for (int j = 0; j < matriz[i].length; j++) {            // 1 + n + 1 + 2n -> 2 + 3n
                sumaTotal += matriz[i][j];      // 3n
                cont++;         // 2n
            }
        }
        return sumaTotal / cont;    // 1
    
    }


    public static void main(String[] args) {
        int[][] matriz = {{4,5,6}, {7,8,9}, {5,6,7}};
        double promedio = promedio(matriz);
        System.out.println("El promedio de los elementos de la matriz es: " + promedio);
    }
}


/*    'La n que multiplica es porque el segundo for se hace n veces'
 * f(n) = 1 + 1 + 2 + 3n + n(3n + 2 + 3n + 2n) = 8n^2 + 5n + 4
 * 
 *    'Es n^2 porque es el mayor grado de la funcion'
 * 8n^2 + 5n + 4 <= c.n^2      
 * 8n^2/n^2 + 5n/n^2 + 4/n^2 <= c.n^2/n^2           <= Dividimos por n^2
 * 8 + 5/n + 4/n^2 <= c
 * Buscamos un valor para n
 * n = 1
 * 8 + 5 + 4 = 17 = c
 * 
 * f(n) = 8n^2 + 5n + 3 pertenece a O(n^2) para c = 17 y n = 1
 */