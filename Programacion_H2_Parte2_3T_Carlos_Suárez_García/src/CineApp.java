import java.util.Scanner;

public class CineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ServicioCine servicioCine = new ServicioCine();

        do {
            System.out.println("\n--- Men� Cine ---");
            System.out.println("1 - Ver pel�culas");
            System.out.println("2 - A�adir pel�cula");
            System.out.println("3 - Eliminar pel�cula");
            System.out.println("4 - Modificar pel�cula");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opci�n: ");
            
            // Comprobar si la entrada es un n�mero entero
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un n�mero v�lido.");
                scanner.next(); // limpiar entrada inv�lida
                System.out.print("Seleccione una opci�n: ");
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
                    System.out.println("�Gracias por usar la aplicaci�n! Hasta luego.");
                    break;
                default:
                    System.out.println("Opci�n no v�lida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

