public class ArbolBinarioBusqueda {
    private Nodo raiz;

    // Constructor
    ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    // Verificar si el árbol está vacío
    public boolean esVacio() {
        return (this.raiz == null);
    }

    // Obtener la raíz del árbol
    public Nodo obtenerRaiz() {
        return this.raiz;
    }

    // Insertar un valor en el árbol
    public void insertarValor(int valor) {
        if (this.raiz == null) {
            System.out.println("Insertando raíz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        } else {
            insertarNodo(valor, this.raiz);
        }
    }

    // Método auxiliar para insertar un nodo en el árbol
    private void insertarNodo(int valor, Nodo nodoRef) {
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null) {
                System.out.println("Insertando hijo izquierdo de " + nodoRef.dato + ": " + valor);
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
                    System.out.println("Insertando hijo derecho de " + nodoRef.dato + ": " + valor);
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

    // Imprimir el árbol horizontalmente
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

    // Realizar un recorrido en orden del árbol
    public void enOrden(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        enOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        enOrden(nodoRef.derecho);
    }

    // Realizar un recorrido en preorden del árbol
    public void preOrden(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        System.out.print(nodoRef.dato + " - ");
        preOrden(nodoRef.izquierdo);
        preOrden(nodoRef.derecho);
    }

    // Realizar un recorrido en postorden del árbol
    public void postOrden(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        postOrden(nodoRef.izquierdo);
        postOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }

    // Buscar un valor en el árbol
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

    // Podar el árbol, eliminando todos los nodos
    public void podarArbol(Nodo nodoRef) {
        if (nodoRef == null)
            return;
        // Podar el subárbol izquierdo
        podarArbol(nodoRef.izquierdo);
        // Podar el subárbol derecho
        podarArbol(nodoRef.derecho);
        // Podar el nodo actual
        nodoRef = null;
    }

    // Encontrar el nodo con el valor más grande en el árbol
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
        if (nodoRef == null) {
            return;
        } else if (x < nodoRef.dato) {
            eliminarPredecesor(x, nodoRef.izquierdo);
        } else if (x > nodoRef.dato) {
            eliminarPredecesor(x, nodoRef.derecho);
        } else if (nodoRef.izquierdo != null && nodoRef.derecho != null) {
            Nodo mayor = buscarMayor(nodoRef.izquierdo);
            nodoRef.dato = mayor.dato;
            eliminarPredecesor(mayor.dato, nodoRef.izquierdo);
        } else {
            if (nodoRef.izquierdo == null) {
                nodoRef = nodoRef.derecho;
            } else if (nodoRef.derecho == null) {
                nodoRef = nodoRef.izquierdo;
            }
        }
    }
}
