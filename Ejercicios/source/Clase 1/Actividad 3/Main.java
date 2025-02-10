package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los dos números
        System.out.print("Ingrese el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

        // Solicitar la operación matemática
        System.out.print("Ingrese la operación: \n1.suma\n2.resta\n3.multiplicación\n4.división\n");
        int operacion = scanner.nextInt();

        // Realizar la operación seleccionada
        double resultado;
        switch (operacion) {
            case 1:
                resultado = numero1 + numero2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;
            case 2:
                resultado = numero1 - numero2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;
          
            case 3:
                resultado = numero1 * numero2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;
 
            case 4:
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("El resultado de la división es: " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operación no válida. Intente con suma, resta, multiplicación o división.");
        }

        scanner.close();
    }

}
