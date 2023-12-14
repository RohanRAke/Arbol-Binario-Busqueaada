// This class represents a Binary Search Tree
public class ArbolBinarioBusqueda {
    
    // The root node of the tree
    private Nodo raiz;

    // Constructor
    ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    // Check if the tree is empty
    public boolean esVacio() {
        return (this.raiz == null);
    }

    // Get the root of the tree
    public Nodo obtenerRaiz() {
        return this.raiz;
    }

    // Insert a value into the tree
    public void insertarValor(int valor) {
        if (this.raiz == null) {
            System.out.println("Inserting root: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        } else {
            insertarNodo(valor, this.raiz);
        }
    }

    // Auxiliary method to insert a node into the tree
    private void insertarNodo(int valor, Nodo nodoRef) {
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null) {
                System.out.println("Inserting left child of " + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo = new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            } else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        } else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null) {
                    System.out.println("Inserting right child of " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho = new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                } else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }

    // Print the tree horizontally
    public void imprimirArbolHorizontal(int nivel, Nodo nodoRef) {
        if (nodoRef == null) {
            return;
        } else {
            imprimirArbolHorizontal(nivel + 1, nodoRef.derecho);

            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }

            System.out.println("[" + nodoRef.dato + "]");
            imprimirArbolHorizontal(nivel + 1, nodoRef.izquierdo);
        }
    }

    // Perform an in-order traversal of the tree
    public void enOrden(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        enOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        enOrden(nodoRef.derecho);
    }

    // Perform a pre-order traversal of the tree
    public void preOrden(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        System.out.print(nodoRef.dato + " - ");
        preOrden(nodoRef.izquierdo);
        preOrden(nodoRef.derecho);
    }

    // Perform a post-order traversal of the tree
    public void postOrden(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        postOrden(nodoRef.izquierdo);
        postOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }

    // Search for a value in the tree
    public boolean busqueda(int x, Nodo nodoRef) {
        if (nodoRef == null)
            return false;
        else if (x < nodoRef.dato)
            return busqueda(x, nodoRef.izquierdo);
        else if (x > nodoRef.dato)
            return busqueda(x, nodoRef.derecho);
        else
            return true;
    }

    // Prune the tree, removing all nodes
    public void podarArbol(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        // Prune the left subtree
        podarArbol(nodoRef.izquierdo);
        // Prune the right subtree
        podarArbol(nodoRef.derecho);
        // Prune the current node
        nodoRef = null;
    }

    // Find the node with the largest value in the tree
    public Nodo buscarMayor(Nodo nodoRef) {
        if (nodoRef == null) {
            return null;
        } else if (nodoRef.derecho == null) {
            return nodoRef;
        } else {
            return buscarMayor(nodoRef.derecho);
        }
    }

   // Eliminar el predecesor de un valor dado en el árbol
public void eliminarPredecesor(int x, Nodo nodoRef) {
    // If the current node is null, return (base case)
    if (nodoRef == null) {
        return;
    }
    // If the value to be deleted is less than the current node's value, go left
    else if (x < nodoRef.dato) {
        eliminarPredecesor(x, nodoRef.izquierdo);
    }
    // If the value to be deleted is greater than the current node's value, go right
    else if (x > nodoRef.dato) {
        eliminarPredecesor(x, nodoRef.derecho);
    }
    // If the node to be deleted has two children
    else if (nodoRef.izquierdo != null && nodoRef.derecho != null) {
        // Find the node with the maximum value in the left subtree (predecessor)
        Nodo mayor = buscarMayor(nodoRef.izquierdo);
        // Replace the current node's value with the predecessor's value
        nodoRef.dato = mayor.dato;
        // Recursively delete the predecessor from the left subtree
        eliminarPredecesor(mayor.dato, nodoRef.izquierdo);
    }
    // If the node to be deleted has one or no child
    else {
        // If the left child is null, replace the current node with its right child
        if (nodoRef.izquierdo == null) {
            nodoRef = nodoRef.derecho;
        }
        // If the right child is null, replace the current node with its left child
        else if (nodoRef.derecho == null) {
            nodoRef = nodoRef.izquierdo;
        }
    }
}

}
