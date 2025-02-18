package Ejercicios.source.Clase11.Actividad3;

public class Actividad3 {
    private static int[][] oficina = new int[4][4];
    private static boolean[] computadorasColumnas = new boolean[4];
    private static boolean[] impresorasColumnas = new boolean[4];
    private static int soluciones = 0;

    public static void main(String[] args) {
        colocarEquipos();
        System.out.println("Número de soluciones: " + soluciones);
    }

    public static void colocarEquipos() {
        colocarEquipos(0);
    }

    public static void colocarEquipos(int fila) {
        if (fila == 4) {
            soluciones++;
            imprimirTablero();
            return;
        }

        for (int columna = 0; columna < 4; columna++) {
            if (!computadorasColumnas[columna]) {
                oficina[fila][columna] = 1;
                computadorasColumnas[columna] = true;

                for (int columnaImpresora = 0; columnaImpresora < 4; columnaImpresora++) {
                    if (!impresorasColumnas[columnaImpresora] && columnaImpresora != columna) {
                        oficina[fila][columnaImpresora] = 2;
                        impresorasColumnas[columnaImpresora] = true;

                        colocarEquipos(fila + 1);

                        oficina[fila][columnaImpresora] = 0;
                        impresorasColumnas[columnaImpresora] = false;
                    }
                }

                oficina[fila][columna] = 0;
                computadorasColumnas[columna] = false;
            }
        }
    }

    public static void imprimirTablero() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(oficina[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
