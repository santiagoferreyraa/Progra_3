package Ejercicios.source.Clase4.Actividad1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Cliente mayorScore(List<Cliente> c, int ini, int fin){
        if (ini == fin) return c.get(ini);

        int mid = (ini + fin) / 2;
        Cliente mayorIzq = mayorScore(c, ini, mid);
        Cliente mayorDer = mayorScore(c, mid + 1, fin);

        return mayorIzq.scoring > mayorDer.scoring ? mayorIzq : mayorDer;
    }
    public static void main(String[] args) {
        List<Cliente> clients = new ArrayList<>();
        clients.add(new Cliente(1, "Juan", 50));
        clients.add(new Cliente(2, "Agustin", 55));
        clients.add(new Cliente(3, "Santiago", 54));

        System.out.println(mayorScore(clients, 0, clients.size()-1));

    }
}
