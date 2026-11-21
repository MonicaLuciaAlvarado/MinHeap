import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();
        int opcion;

        do {
            System.out.println("\n===== MIN HEAP =====");
            System.out.println("1. Insertar número");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Consultar mínimo");
            System.out.println("4. Crear montículo desde un arreglo");
            System.out.println("5. Mostrar montículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número: ");
                    int numero = sc.nextInt();
                    heap.insertar(numero);
                    System.out.println("Número insertado.");
                    break;

                case 2:
                    int eliminado = heap.pop();

                    if (eliminado != -1) {
                        System.out.println("Número eliminado: " + eliminado);
                    }
                    break;

                case 3:
                    int minimo = heap.peek();

                    if (minimo != -1) {
                        System.out.println("Mínimo: " + minimo);
                    }
                    break;

                case 4:
                    int[] arreglo = {
                            85, 42, 73, 19, 56, 91, 34, 12,
                            67, 28, 95, 43, 76, 8, 51, 39,
                            62, 14, 87, 23, 70, 45, 98, 31,
                            59, 16, 82, 5, 48, 26, 64
                    };

                    heap.heapify(arreglo);
                    System.out.println("Montículo creado.");
                    heap.mostrar();
                    break;

                case 5:
                    System.out.println("Montículo actual:");
                    heap.mostrar();
                    break;

                case 6:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}