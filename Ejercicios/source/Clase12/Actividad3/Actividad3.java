package Ejercicios.source.Clase12.Actividad3;

public class Actividad3 {
    public static void main(String[] args) {
        GrafoAlmacenes redAlmacenes = new GrafoAlmacenes();
        Almacen almacen1 = new Almacen(1, "SDFL");
        Almacen almacen2 = new Almacen(2, "ERTIO");
        Almacen almacen3 = new Almacen(3, "GFKME");
        Almacen almacen4 = new Almacen(4, "EPRK");
        Almacen almacen5 = new Almacen(5, "DMFL");

        redAlmacenes.agregarAlmacen(almacen1);
        redAlmacenes.agregarAlmacen(almacen2);
        redAlmacenes.agregarAlmacen(almacen3);
        redAlmacenes.agregarAlmacen(almacen4);
        redAlmacenes.agregarAlmacen(almacen5);

        redAlmacenes.conectarAlmacenes(almacen1, almacen5);
        redAlmacenes.conectarAlmacenes(almacen5, almacen3);
        redAlmacenes.conectarAlmacenes(almacen3, almacen4);
        redAlmacenes.conectarAlmacenes(almacen4, almacen2);
        redAlmacenes.conectarAlmacenes(almacen2, almacen3);
        redAlmacenes.conectarAlmacenes(almacen2, almacen1);

        redAlmacenes.BFS(almacen1);
        System.out.println();
        redAlmacenes.DFS(almacen1);
    }
}
