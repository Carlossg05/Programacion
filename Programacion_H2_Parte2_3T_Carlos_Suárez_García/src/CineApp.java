import java.util.Scanner;

public class CineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ServicioCine servicioCine = new ServicioCine();

        do {
            System.out.println("\n--- Menú Cine ---");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Añadir película");
            System.out.println("3 - Eliminar película");
            System.out.println("4 - Modificar película");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            
            // Comprobar si la entrada es un número entero
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // limpiar entrada inválida
                System.out.print("Seleccione una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    servicioCine.verPeliculas();
                    break;
                case 2:
                    servicioCine.anadirPelicula(scanner);
                    break;
                case 3:
                    servicioCine.eliminarPelicula(scanner);
                    break;
                case 4:
                    servicioCine.modificarPelicula(scanner);
                    break;
                case 5:
                    System.out.println("¡Gracias por usar la aplicación! Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

