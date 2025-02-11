//Un sistema de facturación, recibe una lista de comprobantes facturas
//electrónicas, con id de factura, id de cliente, e importe y una lista de clientes, con
//id cliente, y nombre de cliente, realizar un código de java, que genere otra lista,
//con id cliente, nombre de cliente, suma importes de las facturas.
//Realizar la implementación en java, sin Maps y luego con Maps, ¿ cuál es la
//diferencia en cuanto a la complejidad asintótica ?
package main;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import models.Cliente;
import models.Factura;
import models.TotalFacturado;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente("Luciano"));
		clientes.add(new Cliente("Agustin"));
		clientes.add(new Cliente("Nacho"));
		clientes.add(new Cliente("Nico"));
		
		List<Factura> facturas = new ArrayList<>();
		facturas.add(new Factura(1, 30.5));
		facturas.add(new Factura(4, 10));
		facturas.add(new Factura(2, 10.5));
		facturas.add(new Factura(3, 40.5));
		facturas.add(new Factura(2, 10.5));
		facturas.add(new Factura(1, 20));
		
		List<TotalFacturado> facturasTotales = importeTotalSinMap(clientes, facturas);
		System.out.println("SIN MAP");
		for(TotalFacturado factura : facturasTotales) {
			System.out.println("Id Cliente: " + factura.getIdCliente() + "\nNombre Cliente: " + factura.getNombreCliente() + "\nImporte Total: " + factura.getImporteTotal() + "\n");
		}
		
		List<TotalFacturado> facturasTotalesMap = importeTotalConMap(clientes, facturas);
		System.out.println("CON MAP");
		for(TotalFacturado factura : facturasTotalesMap) {
			System.out.println("Id Cliente: " + factura.getIdCliente() + "\nNombre Cliente: " + factura.getNombreCliente() + "\nImporte Total: " + factura.getImporteTotal() + "\n");
		}
	}

	public static List<TotalFacturado> importeTotalSinMap(List<Cliente> clientes, List<Factura> facturas) {
		List<TotalFacturado> facturasTotales = new ArrayList<>();
		double acumulado = 0;
		for(Cliente cliente : clientes) {
			for(Factura factura : facturas) {
				if(cliente.getIdCliente() == factura.getIdCliente()) {
					acumulado += factura.getImporte();
				}
			}
			facturasTotales.add(new TotalFacturado(cliente.getIdCliente(), cliente.getNombreCliente(), acumulado));
			acumulado = 0;
		}
		
		return facturasTotales;
	}
	
	public static List<TotalFacturado> importeTotalConMap(List<Cliente> clientes, List<Factura> facturas){
		HashMap<Integer, Double> facturasTotales = new HashMap<>();
		
		for (Factura factura : facturas) {
			facturasTotales.put(factura.getIdCliente(), facturasTotales.getOrDefault(factura.getIdCliente(), 0.0) + factura.getImporte());
		}
		
		List<TotalFacturado> respuesta = new ArrayList<>();
		for (Cliente cliente : clientes) {
			respuesta.add(new TotalFacturado(cliente.getIdCliente(), cliente.getNombreCliente(), facturasTotales.get(cliente.getIdCliente())));
		}
		
		return respuesta;
	}
}

//Enfoque sin Map (Método importeTotalSinMap)
//Recorre la lista de clientes.
//Para cada cliente, recorre la lista de facturas buscando las facturas asociadas a ese cliente y acumulando el 
//importe de las facturas correspondientes.
//Luego agrega el resultado a una nueva lista de TotalFacturado.
//Complejidad Asintótica:

//Para cada cliente, se recorre toda la lista de facturas. Si hay n clientes y m facturas, la complejidad es 
//O(n * m).

//Enfoque con Map (Método importeTotalConMap)
//Primero, recorre la lista de facturas y acumula el importe total por cliente en un HashMap donde la clave es el 
//idCliente y el valor es el importe acumulado.
//Luego, recorre la lista de clientes y busca el total de facturación en el HashMap para cada cliente.
//Complejidad Asintótica:

//La primera parte (recorriendo las facturas) tiene una complejidad de O(m) donde m es el número de facturas.
//La segunda parte (recorriendo los clientes) tiene una complejidad de O(n), donde n es el número de clientes.
//La complejidad total es O(m + n).

//Sin Map: La complejidad es O(n * m), lo que puede ser costoso si hay muchas facturas y clientes.
//Con Map: La complejidad es O(m + n), que es más eficiente, especialmente cuando hay muchas facturas, ya que
//se evita la necesidad de recorrer todas las facturas por cada cliente.
