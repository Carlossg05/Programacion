package Animal;

public class Perro extends Animal {
    String tamaño; // Tamaño del perro.

    public Perro(String string, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
        super(string, nombre, edad, raza, adoptado); // Llama al constructor de Animal.
        this.tamaño = tamaño; // Asigna el tamaño del perro.
    }

    public Perro(String nombre, int edad, String raza, boolean adoptado, String tamaño) {
        super(0, nombre, edad, raza, adoptado); // Llama al constructor de Animal con chip 0.
        this.tamaño = tamaño; // Asigna el tamaño del perro.
    }

    @Override
    public void mostrarDatos() { // Muestra los datos del perro.
        System.out.println("Chip del perro: " + numeroChip);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
        System.out.println("Adoptado: " + adoptado);
        System.out.println("Tamaño: " + tamaño);
    }

    @Override
    protected Object getnumero_de_chip() { // Devuelve el número de chip.
        return numeroChip;
    }

	@Override
	protected String getChip() { // TODO: Implementar obtención de chip como String.
		return null;
	}
}