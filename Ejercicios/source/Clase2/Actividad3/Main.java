package Ejercicios.source.Clase2.Actividad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        
        class Facturacion{
            protected int idCliente;
            protected String nombreCliente;
            protected double sumaImportes;

            public Facturacion(int idCliente, String nombreCliente, double sumaImportes) {
                this.idCliente = idCliente;
                this.nombreCliente = nombreCliente;
                this.sumaImportes = sumaImportes;
            }

            @Override
            public String toString() {
                return ("Cliente: " + nombreCliente +
                        "\nID: " + idCliente +
                        "Suma de Importes: " + sumaImportes);
            }
        }

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan"));
        clientes.add(new Cliente(2, "Maximo"));
        clientes.add(new Cliente(3, "Jose"));

        List<Factura> facturas = new ArrayList<>();

        facturas.add(new Factura(1, 1, 1000.0));
        facturas.add(new Factura(2, 2, 2000.0));
        facturas.add(new Factura(3, 3, 3000.0));

        Map<Integer, Cliente> clienteMapa = new HashMap<>();
        for (Cliente cliente : clientes) {
            clienteMapa.put(cliente.idCliente, cliente);
        }
        
        Map<Integer, Double> facturasMapa = new TreeMap<>();
        for (Factura factura : facturas) {
            facturasMapa.put(factura.idCliente, facturasMapa.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<Facturacion> resultado = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : facturasMapa.entrySet()){
            int idCliente = entry.getKey();
            Cliente cliente = clienteMapa.get(idCliente);
            resultado.add(new Facturacion(idCliente, cliente.nombre, entry.getValue()));
        }
        for (Facturacion facturacion : resultado){
            System.out.println(facturacion);
        }
    }
}
