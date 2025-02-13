package Ejercicios.source.Clase1.Actividad2;
import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu ciudad de residencia: ");
        String ciudad = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();
        int edadSumada = edad + 2;

        System.out.print("Introduce tu altura en metros: ");
        double altura = sc.nextDouble();
        double alturaMultiplicada = altura * 2;

        System.out.print("Introduce la inicial de tu primer nombre: ");
        char inicialNombre = sc.next().charAt(0);
        String inicialConcatenada = "Tu inicial es " + inicialNombre;
        
        System.out.println(edadSumada);
        System.out.println(alturaMultiplicada);
        System.out.println(inicialConcatenada);
        System.out.println(ciudad);

        sc.close();
    }
}