public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);

        System.out.println("Recorrido en preorden del árbol:");
        arbol.preOrden();  // Imprimirá 50, 30, 20, 40, 70

        System.out.println("Recorrido en orden del árbol:");
        arbol.enOrden();  // Imprimirá 20, 30, 40, 50, 70

        System.out.println("Recorrido en postorden del árbol:");
        arbol.postOrden();  // Imprimirá 20, 40, 30, 70, 50
    }
}
