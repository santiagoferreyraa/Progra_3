package Ejercicios.Clase2.Actividad3;

import java.util.ArrayList;
import java.util.HashMap;

public class Actividad3 {
    public ArrayList<ClienteFacturaSinMap> SinMaps(Cliente[] clientes, Factura[] facturas) {
        ArrayList<ClienteFacturaSinMap> clientefactura = new ArrayList<>(); // O(1)

        for (int i = 0; i < clientes.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            int suma = 0; // O(n)

            for (int j = 0; j < facturas.length; j++) { // O(n + n^2 + 2n^2) = O(n + 3n^2)
                if (facturas[j].getIdCliente() == clientes[i].getIdCliente()) { // O(n^2)
                    suma += facturas[j].getImporte(); // O(2n^2)
                }
            }

            clientefactura.add(new ClienteFacturaSinMap(clientes[i].getIdCliente(), clientes[i].getNombre(), suma)); // O (n)
        }

        return clientefactura; // O(1)

        // 1 + 1 + 3n + n + n + 3n^2 + n^2 + 2n^2 + n + 1 = 3 + 6n + 6n^2 <= c.n
        //                                                   3/n + 6 + 6n <= c
        //                                                             n0 == 1
        //                                                      3 + 6 + 6 <= c
        //                                                             15 <= c
        // f(n) = 3 + 6n + 6n^2 pertenece a O(n^2) para c = 15 y n0 = 1.
    }

    public static HashMap<Integer, ClienteFacturaConMap> ConMaps(Cliente[] clientes, Factura[] facturas) {
        HashMap<Integer, Integer> sumasFacturas = sumarFacturas(facturas); // O(n.log(n))
        HashMap<Integer, ClienteFacturaConMap> clienteFactura = new HashMap<>(); // O(1)

        for (Cliente cliente : clientes) { // O(1 + 3n)
            int suma = sumasFacturas.getOrDefault(cliente.getIdCliente(), 0); // O(3n)
            clienteFactura.put(cliente.getIdCliente(), new ClienteFacturaConMap(cliente.getNombre(), suma)); // O(3n)
        }

        return clienteFactura; // O(1)

        // n.log(n) + 1 + 1 + 3n + 3n + 3n + 1 = 3 + 9n + n.log(n) <= c.n
        //                                        3/n + 9 + log(n) <= c
        //                                                      n0 == 1
        //                                               3 + 9 + 0 <= c
        //                                                      12 <= c
        // f(n) = 3 + 9n + n.log(n) pertenece a O(n.log(n)) para c = 12 y n0 = 1.
    }

    public static HashMap<Integer, Integer> sumarFacturas(Factura[] facturas) {
        return dividirFacturas(facturas, 0, facturas.length - 1); // O(n.log(n))
    }

    private static HashMap<Integer, Integer> dividirFacturas(Factura[] facturas, int inicio, int fin) {
        HashMap<Integer, Integer> resultado = new HashMap<>(); // O(1)

        if (inicio == fin) { // O(1)
            resultado.put(facturas[inicio].getIdCliente(), facturas[inicio].getImporte()); // O(3)
            return resultado; // O(1)
        }

        int medio = (inicio + fin) / 2; // O(3)
        HashMap<Integer, Integer> izquierda = dividirFacturas(facturas, inicio, medio); // T(n/2)
        HashMap<Integer, Integer> derecha = dividirFacturas(facturas, medio + 1, fin); // T(n/2)

        for (int id : izquierda.keySet()) { // O(1 + 3n)
            resultado.put(id, izquierda.getOrDefault(id, 0) + derecha.getOrDefault(id, 0)); // O(4n)
        }

        for (int id : derecha.keySet()) { // O(1 + 3n)
            if (!resultado.containsKey(id)) { // O(n)
                resultado.put(id, derecha.get(id)); // O(2n)
            }
        }

        return resultado; // O(1)

        // T(n) = 2.T(n/2) + O(12 + 13n)
        // a = b^k
        // 2 = 2^1
        // Como a = b^k, la complejidad es O(n.log(n)) por el teorema maestro.
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Juan"),
                new Cliente(2, "María"),
                new Cliente(3, "Carlos")
        };

        Factura[] facturas = {
                new Factura(1, 1, 500),
                new Factura(2, 2, 150),
                new Factura(3, 1, 300),
                new Factura(4, 3, 200),
                new Factura(5, 2, 350)
        };

        // Sin Maps
        System.out.println("Sin maps:");
        for (ClienteFacturaSinMap clienteFacturaSinMap : new Actividad3().SinMaps(clientes, facturas)) {
            System.out.println(clienteFacturaSinMap);
        }
        System.out.println();

        // Con Maps
        System.out.println("Con maps:");

        for (ClienteFacturaConMap clienteFacturaConMap : new Actividad3().ConMaps(clientes, facturas).values()) {
            System.out.println(clienteFacturaConMap);
        }
    }
}

class Cliente {
    private int idCliente;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

class ClienteFacturaConMap {
    private String nombre;
    private int suma;

    public ClienteFacturaConMap(String nombre, int suma) {
        this.nombre = nombre;
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +
                "\nsuma: " + suma;
    }
}

class ClienteFacturaSinMap {
    private int idCliente;
    private String nombre;
    private int suma;

    public ClienteFacturaSinMap(int idCliente, String nombre, int suma) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.suma = suma;
    }

    @Override
    public String toString() {
        return  "idCliente: " + idCliente +
                "\nnombre: " + nombre +
                "\nsuma: " + suma;
    }
}

class Factura {
    private int idFactura;
    private int idCliente;
    private int importe;

    public int getIdCliente() {
        return idCliente;
    }

    public int getImporte() {
        return importe;
    }

    public Factura(int idFactura, int idCliente, int importe) {
        this.idFactura = idFactura;
        this.importe = importe;
        this.idCliente = idCliente;
    }
}
