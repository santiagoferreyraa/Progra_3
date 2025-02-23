package main;

public class DistribucionOficinaEquipoElectronico {
    private static final int N = 4;
    private static int soluciones = 0;
    
    public static void main(String[] args) {
        int[] computadoras = new int[N];
        int[] impresoras = new int[N];
        
        colocarComputadoras(computadoras, impresoras, 0);
        System.out.println("Total de soluciones: " + soluciones);
    }
    
    private static void colocarComputadoras(int[] computadoras, int[] impresoras, int fila) {
        if (fila == N) {
            colocarImpresoras(computadoras, impresoras, 0);
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (esValido(computadoras, fila, col)) {
                computadoras[fila] = col;
                colocarComputadoras(computadoras, impresoras, fila + 1);
            }
        }
    }
    
    private static void colocarImpresoras(int[] computadoras, int[] impresoras, int fila) {
        if (fila == N) {
            imprimirSolucion(computadoras, impresoras);
            soluciones++;
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (esValido(impresoras, fila, col) && col != computadoras[fila]) {
                impresoras[fila] = col;
                colocarImpresoras(computadoras, impresoras, fila + 1);
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
    
    private static void imprimirSolucion(int[] computadoras, int[] impresoras) {
        System.out.println("\nSolución " + (soluciones + 1) + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (computadoras[i] == j) {
                    System.out.print(" C ");
                } else if (impresoras[i] == j) {
                    System.out.print(" I ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
