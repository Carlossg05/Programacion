package Animal;
import java.util.*;

public class SistemaDeAnimales {
    // Lista para guardar los animales registrados.
    private List<Animal> animales = new ArrayList<>();
    // Lista para guardar los registros de adopci�n.
    private List<Adopcion> adopciones = new ArrayList<>();

    // A�ade un animal a la lista de animales.
    public void altaAnimal(Animal animal) {
        animales.add(animal);
        System.out.println("Animal dado de alta correctamente.");
    }

    // Muestra la informaci�n de todos los animales registrados.
    public void listarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }
        for (Animal a : animales) {
            System.out.println(a);
        }
    }

    // Busca un animal por su n�mero de chip.
    public Animal buscarAnimal(String chip) {
        for (Animal a : animales) {
            if (a.getChip().equals(chip)) {
                return a;
            }
        }
        return null; // No se encontr� el animal.
    }

    // Verifica si un animal con un chip espec�fico ha sido adoptado.
    public boolean estaAdoptado(String chip) {
        for (Adopcion a : adopciones) {
            if (a.getAnimal().getChip().equals(chip)) {
                return true;
            }
        }
        return false;
    }

    // Registra la adopci�n de un animal.
    public void realizarAdopcion(String chip, String nombre, String dni) {
        Animal animal = buscarAnimal(chip);
        if (animal == null) {
            System.out.println("Animal no encontrado.");
        } else if (estaAdoptado(chip)) {
            System.out.println("El animal ya ha sido adoptado.");
        } else {
            adopciones.add(new Adopcion(animal, nombre, dni));
            System.out.println("Adopci�n realizada con �xito.");
        }
    }

    // Elimina un animal del sistema por su n�mero de chip.
    public void darDeBaja(String chip) {
        Animal animal = buscarAnimal(chip);
        if (animal == null) {
            System.out.println("Animal no encontrado.");
            return;
        }
        animales.remove(animal);
        adopciones.removeIf(a -> a.getAnimal().getChip().equals(chip));
        System.out.println("Animal dado de baja correctamente.");
    }

    // Muestra estad�sticas sobre la cantidad de gatos y gatos con leucemia.
    public void mostrarEstadisticasGatos() {
        long totalGatos = animales.stream().filter(a -> a instanceof Gato).count();
        long gatosLeucemia = animales.stream()
            .filter(a -> a instanceof Gato)
            .map(a -> (Gato) a)
            .filter(Gato::testLeucemia)
            .count();
        System.out.println("Total de gatos: " + totalGatos);
        System.out.println("Gatos con leucemia: " + gatosLeucemia);
    }
}