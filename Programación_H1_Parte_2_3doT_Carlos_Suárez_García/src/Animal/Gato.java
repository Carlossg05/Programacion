package Animal;

public class Gato extends Animal {
    boolean testLeucemia; // Indica si el gato tiene leucemia.

    public Gato(String string, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
        super(string, nombre, edad, raza, adoptado); // Llama al constructor de Animal.
        this.testLeucemia = testLeucemia; // Asigna el resultado del test de leucemia.
    }

    public Gato(String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
        super(0, nombre, edad, raza, adoptado); // Llama al constructor de Animal con chip 0.
        this.testLeucemia = testLeucemia; // Asigna el resultado del test de leucemia.
    }

    @Override
    public void mostrarDatos() { // Implementa el método abstracto de Animal.
        System.out.println("Chip del gato: " + numeroChip);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
        System.out.println("Adoptado: " + adoptado);
        System.out.println("Test de leucemia: " + testLeucemia);
    }

    @Override
    protected Object getnumero_de_chip() { // Implementa el método abstracto de Animal.
        return numeroChip;
    }

	@Override
	protected String getChip() { // Implementa el método abstracto de Animal.
		return null; // Actualmente no devuelve el chip como String.
	}

    public boolean testLeucemia() { // Getter para el atributo testLeucemia.
        return testLeucemia;
    }
}