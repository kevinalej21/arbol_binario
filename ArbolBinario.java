public class ArbolBinario<T extends Comparable<T>> {
    NodoArbol<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol<T> insertarRec(NodoArbol<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoArbol<>(dato);
        }
        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecho = insertarRec(nodo.derecho, dato);
        }
        return nodo;
    }

    public void eliminar(T dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private NodoArbol<T> eliminarRec(NodoArbol<T> nodo, T dato) {
        if (nodo == null) {
            return nodo;
        }
        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecho = eliminarRec(nodo.derecho, dato);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            nodo.dato = encontrarMin(nodo.derecho);
            nodo.derecho = eliminarRec(nodo.derecho, nodo.dato);
        }
        return nodo;
    }

    private T encontrarMin(NodoArbol<T> nodo) {
        T min = nodo.dato;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    public void preOrden() {
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrdenRec(nodo.izquierdo);
            preOrdenRec(nodo.derecho);
        }
    }

    public void enOrden() {
        enOrdenRec(raiz);
        System.out.println();
    }

    private void enOrdenRec(NodoArbol<T> nodo) {
        if (nodo != null) {
            enOrdenRec(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            enOrdenRec(nodo.derecho);
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol<T> nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo);
            postOrdenRec(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    public void visualizar() {
        visualizarRec(raiz, 0);
    }

    private void visualizarRec(NodoArbol<T> nodo, int nivel) {
        if (nodo != null) {
            visualizarRec(nodo.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(nodo.dato);
            visualizarRec(nodo.izquierdo, nivel + 1);
        }
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public int numeroElementos() {
        return numeroElementosRec(raiz);
    }

    private int numeroElementosRec(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + numeroElementosRec(nodo.izquierdo) + numeroElementosRec(nodo.derecho);
    }

    private static class NodoArbol<T> {
        T dato;
        NodoArbol<T> izquierdo;
        NodoArbol<T> derecho;

        NodoArbol(T dato) {
            this.dato = dato;
            this.izquierdo = null;
            this.derecho = null;
        }
    }
}
