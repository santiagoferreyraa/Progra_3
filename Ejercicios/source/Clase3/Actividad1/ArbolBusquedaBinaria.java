package Ejercicios.source.Clase3.Actividad1;


public class ArbolBusquedaBinaria {
    public BSTNode searchBST(BSTNode root, int x) {
        if (root == null || root.value == x) {          // Caso base: 
            return root;                                // Si el nodo es nulo o si el valor del nodo es el que estamos buscando
        }

        /*
         * Si el nodo es menor buscamos en el izquierdo, sino en el derecho
         */

        if (x < root.value) {
            return searchBST(root.left, x);
        }
        return searchBST(root.right, x);
    }

    public static void main(String[] args) {
        ArbolBusquedaBinaria tree = new ArbolBusquedaBinaria();

        // Ejemplo clase:
        BSTNode root = new BSTNode(10);
        root.left = new BSTNode(5);
        root.right = new BSTNode(20);
        root.left.left = new BSTNode(3);
        root.left.right = new BSTNode(7);
        root.right.left = new BSTNode(15);
        root.right.right = new BSTNode(25);
        root.right.right.right = new BSTNode(30);


    }
}


