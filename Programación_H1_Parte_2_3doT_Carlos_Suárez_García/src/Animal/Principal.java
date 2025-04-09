package Animal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        SistemaDeAnimales sistema = new SistemaDeAnimales(); // Crea el sistema de gestión.
        Scanner scanner = new Scanner(System.in); // Para leer la entrada del usuario.
        int opcion; // Guarda la opción del menú.

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Dar de alta animal");
            System.out.println("2 – Listar animales");
            System.out.println("3 – Buscar animal");
            System.out.println("4 – Realizar adopción");
            System.out.println("5 – Dar de baja");
            System.out.println("6 – Mostrar estadísticas de gatos");
            System.out.println("7 – Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Lee la opción del usuario.
                switch (opcion) {
                    case 1: // Dar de alta un animal.
                        System.out.print("¿Es un gato o un perro? (gato/perro): ");
                        String tipo = scanner.nextLine();
                        System.out.print("Introduce chip: ");
                        String chip = scanner.nextLine();
                        System.out.print("Introduce nombre: ");
                        String nombre = scanner.nextLine();
                        if (tipo.equalsIgnoreCase("gato")) {
                            System.out.print("¿Tiene leucemia? (true/false): ");
                            boolean leucemia = Boolean.parseBoolean(scanner.nextLine());
                            sistema.altaAnimal(new Gato(chip, opcion, nombre, leucemia, leucemia));
                        } else if (tipo.equalsIgnoreCase("perro")) {
                            System.out.print("Introduce raza: ");
                            String raza = scanner.nextLine();
                            sistema.altaAnimal(new Perro(chip, opcion, nombre, false, raza));
                        } else {
                            System.out.println("Tipo no válido.");
                        }
                        break;
                    case 2: // Listar todos los animales.
                        sistema.listarAnimales();
                        break;
                    case 3: // Buscar un animal por chip.
                        System.out.print("Introduce el número de chip: ");
                        Animal animal = sistema.buscarAnimal(scanner.nextLine());
                        if (animal != null) {
                            System.out.println(animal);
                        } else {
                            System.out.println("Animal no encontrado.");
                        }
                        break;
                    case 4: // Realizar una adopción.
                        System.out.print("Introduce chip del animal: ");
                        String chipAdoptar = scanner.nextLine();
                        System.out.print("Nombre del adoptante: ");
                        String nombreAdoptante = scanner.nextLine();
                        System.out.print("DNI del adoptante: ");
                        String dni = scanner.nextLine();
                        sistema.realizarAdopcion(chipAdoptar, nombreAdoptante, dni);
                        break;
                    case 5: // Dar de baja un animal por chip.
                        System.out.print("Introduce chip del animal: ");
                        sistema.darDeBaja(scanner.nextLine());
                        break;
                    case 6: // Mostrar estadísticas de gatos.
                        sistema.mostrarEstadisticasGatos();
                        break;
                    case 7: // Salir del programa.
                        System.out.println("Saliendo...");
                        break;
                    default: // Opción inválida.
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) { // Manejo de errores de entrada.
                System.out.println("Error en la entrada: " + e.getMessage());
                opcion = 0;
            }
        } while (opcion != 7); // Repite hasta que el usuario elija salir.
    }
}