import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Perform operations on the binary search tree
        performTreeOperations();
    }

    // Method to perform various operations on the binary search tree
    private static void performTreeOperations() {
        // Initialize a binary search tree
        ArbolBinarioBusqueda tree = initializeTree();

        // Perform in-order, pre-order, and post-order traversals
        performTraversals(tree);

        // Search for a specific value in the tree
        searchForValue(tree);

        // Delete nodes from the tree
        deleteNodes(tree);

        // Display the tree after operations
        displayHorizontalTree(tree);
    }

    // Method to initialize a binary search tree with predefined values
    private static ArbolBinarioBusqueda initializeTree() {
        ArbolBinarioBusqueda tree = new ArbolBinarioBusqueda();
        tree.insertarValor(9);
        tree.insertarValor(2);
        tree.insertarValor(1);
        tree.insertarValor(16);
        tree.insertarValor(6);
        tree.insertarValor(11);
        tree.insertarValor(8);
        tree.insertarValor(4);
        return tree;
    }

    // Method to display the tree in a horizontal format
    private static void displayHorizontalTree(ArbolBinarioBusqueda tree) {
        System.out.println("\nDisplaying the tree horizontally:");
        tree.imprimirArbolHorizontal(0, tree.obtenerRaiz());
    }

    // Method to perform in-order, pre-order, and post-order traversals
    private static void performTraversals(ArbolBinarioBusqueda tree) {
        System.out.println("\nIn-order traversal:");
        tree.enOrden(tree.obtenerRaiz());

        System.out.println("\nPre-order traversal:");
        tree.preOrden(tree.obtenerRaiz());

        System.out.println("\nPost-order traversal:");
        tree.postOrden(tree.obtenerRaiz());
    }

    // Method to search for a specific value in the tree
    private static void searchForValue(ArbolBinarioBusqueda tree) {
        int searchedValue = 16;
        if (tree.busqueda(searchedValue, tree.obtenerRaiz()))
            System.out.println("\nThe value " + searchedValue + " is present in the tree.");
        else
            System.out.println("\nThe value " + searchedValue + " is not present in the tree.");
    }

    // Method to delete nodes from the tree
    private static void deleteNodes(ArbolBinarioBusqueda tree) {
        System.out.println("\nDeleting nodes from the tree:");
        tree.eliminarPredecesor(6, tree.obtenerRaiz());
    }
}
