package main;

public class DistribucionOficina {
    private static final int N = 4;
    private static int soluciones = 0;
    
    public static void main(String[] args) {
        int[] escritorios = new int[N];
        int[] sillas = new int[N];
        
        colocarEscritorios(escritorios, sillas, 0);
        System.out.println("Total de soluciones: " + soluciones);
    }
    
    private static void colocarEscritorios(int[] escritorios, int[] sillas, int fila) {
        if (fila == N) {
            colocarSillas(escritorios, sillas, 0);
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (esValido(escritorios, fila, col)) {
                escritorios[fila] = col;
                colocarEscritorios(escritorios, sillas, fila + 1);
            }
        }
    }
    
    private static void colocarSillas(int[] escritorios, int[] sillas, int fila) {
        if (fila == N) {
            imprimirSolucion(escritorios, sillas);
            soluciones++;
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (esValido(sillas, fila, col) && col != escritorios[fila]) {
                sillas[fila] = col;
                colocarSillas(escritorios, sillas, fila + 1);
            }
        }
    }
    
    private static boolean esValido(int[] posiciones, int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (posiciones[i] == col) {
                return false;
            }
        }
        return true;
    }
    
    private static void imprimirSolucion(int[] escritorios, int[] sillas) {
        System.out.println("\nSolución " + (soluciones + 1) + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (escritorios[i] == j) {
                    System.out.print(" E ");
                } else if (sillas[i] == j) {
                    System.out.print(" S ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
