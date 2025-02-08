package Ejercicios.source.Clase4.Actividad3;

import java.util.ArrayList;
import java.util.List;

public class DosClientesMaximos {

    public static Cliente[] combinar(Cliente[] izquierda, Cliente[] derecha){

        Cliente[] candidatos = {izquierda[0], izquierda[1], derecha[0], derecha[1]};

        Cliente mayor = null, segundoMayor = null;
        for (Cliente c : candidatos) {
            if (c == null) continue;                                                            // TODO: combinar puede ir directamente en la funcions dosClientesMaximos
            if (mayor == null || c.scoring > mayor.scoring) {                                   // Arreglar: devuelve el maximo pero no el segundo mayor, sino el tercero     
                segundoMayor = mayor;
                mayor = c;
            } else if (segundoMayor == null || c.scoring > mayor.scoring) {
                segundoMayor = c;
            }
        }
        return new Cliente[]{mayor, segundoMayor};

    }
    public static Cliente[] dosClientesMaximos(List<Cliente> clients, int ini, int fin) {
        if (ini == fin) {
            return new Cliente[] { clients.get(ini), null};
        }
        if (fin - ini == 1){
            Cliente cliente1 = clients.get(ini);
            Cliente cliente2 = clients.get(fin);
            return cliente1.scoring > cliente2.scoring ? new Cliente[] { cliente1, cliente2 } : new Cliente[]{cliente2, cliente1};
        }
        int medio = (ini + fin) / 2;
        Cliente[] izq = dosClientesMaximos(clients, ini, medio);
        Cliente[] der = dosClientesMaximos(clients, medio + 1, fin);

        return combinar(izq, der);
    }

    public static void main(String[] args) {
        List<Cliente> clients = new ArrayList<>();
        clients.add(new Cliente(1, "Juan", 45));
        clients.add(new Cliente(2, "Agustin", 52));
        clients.add(new Cliente(3, "Santiago", 55));
        clients.add(new Cliente(4, "Maximo", 56));
        clients.add(new Cliente(5, "Julian", 57));

        Cliente[] maximos = dosClientesMaximos(clients, 0, clients.size()-1);
        System.out.println("Clientes con mayor scoring: " + maximos[0].nombre + " y " + maximos[1].nombre);
        System.out.println("Scoring: " + maximos[0].scoring + " y " + maximos[1].scoring);
    }
}
