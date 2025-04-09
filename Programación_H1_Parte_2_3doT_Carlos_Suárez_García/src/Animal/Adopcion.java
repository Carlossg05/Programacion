package Animal;

public class Adopcion {
    private Animal animal; // Animal adoptado.
    private String nombreAdoptante; // Nombre de quien adopta.
    private String dniAdoptante; // DNI del que adopta.

    // Constructor para crear un objeto Adopcion.
    public Adopcion(Animal animal, String nombreAdoptante, String dniAdoptante) {
        this.animal = animal;
        this.nombreAdoptante = nombreAdoptante;
        this.dniAdoptante = dniAdoptante;
    }

    // Getter para obtener el animal adoptado.
    public Animal getAnimal() {
        return animal;
    }

    // Getter para obtener el nombre del adoptante.
    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    // Getter para obtener el DNI del adoptante.
    public String getDniAdoptante() {
        return dniAdoptante;
    }

    // Representación en String del objeto Adopcion.
    @Override
    public String toString() {
        return "Animal chip: " + animal.getChip() + ", Adoptado por: " + nombreAdoptante + " (DNI: " + dniAdoptante + ")";
    }
}