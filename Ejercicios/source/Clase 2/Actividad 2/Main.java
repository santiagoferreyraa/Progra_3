//Escribe un programa que multiplique dos matrices cuadradas de tamaño n×n
//Calcular la complejidad asintótica y justificar.
package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] A = {{1, 2}, {3, 4}};
		double[][] B = {{5, 6}, {7, 8}};
		double C[][] = multiplicarMatrices(A, B);
		
		//imprimir matriz
		for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }
	}
	
	public static double[][] multiplicarMatrices(double[][] A, double[][] B){
		try {
			if (A[0].length != B.length) { // 1
				throw new IllegalArgumentException("El número de columnas de A debe ser igual al número de filas de B."); // 1
	        }
			
			double[][] C = new double[A.length][A[0].length]; // 1
			
			for(int i = 0; i < C.length; i++) {
				for(int j = 0; j < C[0].length; j++) { 
					for(int k = 0; k < C.length; k++) {
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
			
			return C; // 1
			
		} catch (Exception e) {
			System.out.println("Error en la multiplicación de matrices: " + e.getMessage());
	        return null;
		}
		
	}

}
