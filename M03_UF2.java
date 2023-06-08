import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase implementa un menú interactivo para el usuario.
 */
public class M03_UF2 {

    private Scanner scanner;
    private ArrayList<String> listaElementos;

    /**
     * Constructor de la clase MenuInteractivo.
     */
    public M03_UF2() {
        scanner = new Scanner(System.in);
        listaElementos = new ArrayList<>();
    }

    /**
     * Método principal que inicia el menú interactivo.
     */
    public void iniciarMenu() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 5);
    }

    /**
     * Muestra el menú principal en la consola.
     */
    private void mostrarMenuPrincipal() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Mostrar elementos");
        System.out.println("3. Eliminar elemento");
        System.out.println("4. Buscar elemento");
        System.out.println("5. Salir");
        System.out.println("======================");
        System.out.print("Ingrese una opción: ");
    }

    private int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar el buffer del escáner
            System.out.println("Error: Opción inválida. Por favor, ingrese un número válido.");
            return -1;
        }
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarElemento();
                break;
            case 2:
                mostrarElementos();
                break;
            case 3:
                eliminarElemento();
                break;
            case 4:
                buscarElemento();
                break;
            case 5:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Error: Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }
    }

    /**
     * Permite al usuario agregar un elemento a la lista.
     */
    private void agregarElemento() {
        System.out.print("Ingrese el elemento a agregar: ");
        String elemento = scanner.next();
        listaElementos.add(elemento);
        System.out.println("Elemento agregado correctamente.");
    }

    /**
     * Muestra todos los elementos de la lista.
     */
    private void mostrarElementos() {
        System.out.println("=== Elementos en la lista ===");
        if (listaElementos.isEmpty()) {
            System.out.println("No hay elementos en la lista.");
        } else {
            for (String elemento : listaElementos) {
                System.out.println(elemento);
            }
        }
        System.out.println("=============================");
    }

    /**
     * Permite al usuario eliminar un elemento de la lista.
     */
    private void eliminarElemento() {
        if (listaElementos.isEmpty()) {
            System.out.println("No hay elementos en la lista para eliminar.");
        } else {
            System.out.println("=== Elementos en la lista ===");
            for (int i = 0; i < listaElementos.size(); i++) {
                System.out.println(i + ". " + listaElementos.get(i));
            }
            System.out.println("=============================");
            System.out.print("Ingrese el índice del elemento a eliminar: ");
            int indice = leerOpcion();
            if (indice >= 0 && indice < listaElementos.size()) {
                listaElementos.remove(indice);
                System.out.println("Elemento eliminado correctamente.");
            } else {
                System.out.println("Error: Índice inválido. Por favor, ingrese un índice válido.");
            }
        }
    }

    /**
     * Permite al usuario buscar un elemento en la lista.
     */
    private void buscarElemento() {
        if (listaElementos.isEmpty()) {
            System.out.println("No hay elementos en la lista para buscar.");
        } else {
            System.out.print("Ingrese el elemento a buscar: ");
            String elemento = scanner.next();
            int indice = buscarElemento(elemento);
            if (indice != -1) {
                System.out.println("El elemento \"" + elemento + "\" se encuentra en el índice " + indice + ".");
            } else {
                System.out.println("El elemento \"" + elemento + "\" no se encuentra en la lista.");
            }
        }
    }

    private int buscarElemento(String elemento) {
        return buscarElemento(elemento, 0);
    }

    private int buscarElemento(String elemento, int indice) {
        if (indice >= listaElementos.size()) {
            return -1; // Elemento no encontrado
        }
        if (listaElementos.get(indice).equals(elemento)) {
            return indice; // Elemento encontrado
        }
        return buscarElemento(elemento, indice + 1);
    }

    public static void main(String[] args) {
        M03_UF2 menu = new M03_UF2();
        menu.iniciarMenu();
    }
}
