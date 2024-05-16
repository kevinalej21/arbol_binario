public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }
        if (dato < nodo.valor) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
        } else if (dato > nodo.valor) {
            nodo.derecho = insertarRec(nodo.derecho, dato);
        }
        return nodo;
    }

    public void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo eliminarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return nodo;
        }
        if (dato < nodo.valor) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, dato);
        } else if (dato > nodo.valor) {
            nodo.derecho = eliminarRec(nodo.derecho, dato);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            nodo.valor = encontrarMin(nodo.derecho);
            nodo.derecho = eliminarRec(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    private int encontrarMin(Nodo nodo) {
        int min = nodo.valor;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    public void preOrden() {
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrdenRec(nodo.izquierdo);
            preOrdenRec(nodo.derecho);
        }
    }

    public void enOrden() {
        enOrdenRec(raiz);
        System.out.println();
    }

    private void enOrdenRec(Nodo nodo) {
        if (nodo != null) {
            enOrdenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            enOrdenRec(nodo.derecho);
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(Nodo nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo);
            postOrdenRec(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public void visualizar() {
        visualizarRec(raiz, 0);
    }

    private void visualizarRec(Nodo nodo, int nivel) {
        if (nodo != null) {
            visualizarRec(nodo.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(nodo.valor);
            visualizarRec(nodo.izquierdo, nivel + 1);
        }
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public int numeroElementos() {
        return numeroElementosRec(raiz);
    }

    private int numeroElementosRec(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + numeroElementosRec(nodo.izquierdo) + numeroElementosRec(nodo.derecho);
    }
}
