package main;

public class DosReinasBacktracking {
    static final int N = 4;

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];
        colocarReinas(tablero, 0, 0, 0);
    }

    public static void colocarReinas(int[][] tablero, int filaInicio, int colInicio, int reinasColocadas) {
        if (reinasColocadas == 2) {
            imprimirTablero(tablero);
            return;
        }

        for (int fila = filaInicio; fila < N; fila++) {
            for (int col = (fila == filaInicio) ? colInicio : 0; col < N; col++) {
                if (esSeguro(tablero, fila, col)) {
                    tablero[fila][col] = 1;
                    colocarReinas(tablero, fila, col + 1, reinasColocadas + 1);
                    tablero[fila][col] = 0; // Retroceder
                }
            }
        }
    }

    public static boolean esSeguro(int[][] tablero, int fila, int col) {

        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) return false;
        }

        // Verificar diagonales
        for (int i = 1; i < N; i++) {
            if (dentroDelTablero(fila - i, col - i) && tablero[fila - i][col - i] == 1) return false;
            if (dentroDelTablero(fila - i, col + i) && tablero[fila - i][col + i] == 1) return false;
            if (dentroDelTablero(fila + i, col - i) && tablero[fila + i][col - i] == 1) return false;
            if (dentroDelTablero(fila + i, col + i) && tablero[fila + i][col + i] == 1) return false;
        }

        return true;
    }

    public static boolean dentroDelTablero(int fila, int col) {
        return fila >= 0 && fila < N && col >= 0 && col < N;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print(celda == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
