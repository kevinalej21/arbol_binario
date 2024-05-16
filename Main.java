import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = null;

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Construir o inicializar el ÁRBOL BINARIO");
            System.out.println("2. Insertar elementos al ÁRBOL BINARIO");
            System.out.println("3. Eliminar un elemento del ÁRBOL BINARIO");
            System.out.println("4. Consultar el ÁRBOL BINARIO");
            System.out.println("5. Determinar el número de elementos del ÁRBOL BINARIO");
            System.out.println("6. Determinar si el ÁRBOL BINARIO es vacío");
            System.out.println("7. Recorrido en PREORDEN del ÁRBOL BINARIO");
            System.out.println("8. Recorrido en ORDEN del ÁRBOL BINARIO");
            System.out.println("9. Recorrido en POSTORDEN del ÁRBOL BINARIO");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        arbol = new ArbolBinario();
                        System.out.println("ÁRBOL BINARIO inicializado.");
                        break;
                    case 2:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.print("Ingrese el valor a insertar en el árbol (entero): ");
                        if (scanner.hasNextInt()) {
                            int elementoInsertar = scanner.nextInt();
                            arbol.insertar(elementoInsertar);
                            System.out.println("Elemento insertado correctamente en el árbol.");
                        } else {
                            System.out.println("Error: Ingrese un valor entero.");
                            scanner.next(); // Limpiar el buffer del scanner
                        }
                        break;
                    case 3:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.print("Ingrese el valor a eliminar del árbol (entero): ");
                        if (scanner.hasNextInt()) {
                            int elementoEliminar = scanner.nextInt();
                            arbol.eliminar(elementoEliminar);
                            System.out.println("Elemento eliminado correctamente del árbol.");
                        } else {
                            System.out.println("Error: Ingrese un valor entero.");
                            scanner.next(); // Limpiar el buffer del scanner
                        }
                        break;
                    case 4:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.println("ÁRBOL BINARIO:");
                        arbol.visualizar();
                        break;
                    case 5:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.println("Número de elementos en el árbol: " + arbol.numeroElementos());
                        break;
                    case 6:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.println("El árbol está vacío: " + arbol.esVacio());
                        break;
                    case 7:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.println("Recorrido en PREORDEN del árbol:");
                        arbol.preOrden();
                        break;
                    case 8:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.println("Recorrido en ORDEN del árbol:");
                        arbol.enOrden();
                        break;
                    case 9:
                        if (arbol == null) {
                            System.out.println("Error: El árbol no ha sido inicializado.");
                            break;
                        }
                        System.out.println("Recorrido en POSTORDEN del árbol:");
                        arbol.postOrden();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } else {
                System.out.println("Error: Ingrese un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
                opcion = -1; // Establecer una opción inválida para repetir el bucle
            }
        } while (opcion != 0);

        scanner.close();
    }
}
